package org.realityforge.webtack;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLArgsParser;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.getopt4j.CLUtil;
import org.realityforge.webtack.config.RepositoryConfig;

/**
 * The entry point in which to run the tool.
 */
public class Main
{
  private static final int VERSION_OPT = 2;
  private static final int HELP_OPT = 'h';
  private static final int QUIET_OPT = 'q';
  private static final int VERBOSE_OPT = 'v';
  private static final int DIR_OPT = 'd';
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "version",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              VERSION_OPT,
                              "print the version and exit" ),
      new CLOptionDescriptor( "help",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              HELP_OPT,
                              "print this message and exit" ),
      new CLOptionDescriptor( "quiet",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              QUIET_OPT,
                              "Do not output unless an error occurs.",
                              new int[]{ VERBOSE_OPT } ),
      new CLOptionDescriptor( "verbose",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              VERBOSE_OPT,
                              "Verbose output of differences.",
                              new int[]{ QUIET_OPT } ),
      new CLOptionDescriptor( "directory",
                              CLOptionDescriptor.ARGUMENT_REQUIRED,
                              DIR_OPT,
                              "The directory to run the tool from." )
    };
  @Nonnull
  private static final Map<String, Supplier<Command>> COMMAND_MAP =
    Collections.unmodifiableMap( new LinkedHashMap<String, Supplier<Command>>()
    {
      {
        put( AddCommand.COMMAND, AddCommand::new );
        put( FetchCommand.COMMAND, FetchCommand::new );
        put( LoadCommand.COMMAND, LoadCommand::new );
      }
    } );

  public static void main( @Nonnull final String[] args )
  {
    final Environment environment =
      new Environment( System.console(), Paths.get( "" ).toAbsolutePath(), Logger.getGlobal() );
    setupLogger( environment );
    System.exit( run( environment, args ) );
  }

  static int run( @Nonnull final Environment environment, @Nonnull final String... args )
  {
    if ( !processOptions( environment, args ) )
    {
      return ExitCodes.ERROR_PARSING_ARGS_EXIT_CODE;
    }

    try
    {
      return environment.getCommand().run( new CommandContextImpl( environment ) );
    }
    catch ( final TerminalStateException tse )
    {
      final String message = tse.getMessage();
      if ( null != message )
      {
        final Logger logger = environment.logger();
        logger.log( Level.WARNING, message );
        final Throwable cause = tse.getCause();
        if ( null != cause )
        {
          if ( logger.isLoggable( Level.INFO ) )
          {
            logger.log( Level.INFO, "Cause: " + cause.toString() );
            if ( logger.isLoggable( Level.FINE ) )
            {
              logger.log( Level.FINE, null, cause );
            }
          }
        }
      }
      return tse.getExitCode();
    }
    catch ( final Throwable t )
    {
      environment.logger().log( Level.WARNING, t.toString(), t );
      return ExitCodes.ERROR_EXIT_CODE;
    }
  }

  @Nonnull
  static RepositoryConfig loadConfigFile( @Nonnull final Environment environment )
  {
    final Path configFile = environment.getConfigFile();
    try
    {
      return RepositoryConfig.load( configFile );
    }
    catch ( final Throwable t )
    {
      throw new TerminalStateException( "Error: Failed to load config file " + configFile,
                                        t,
                                        ExitCodes.ERROR_LOADING_CONFIG_CODE );
    }
  }

  static void setupLogger( @Nonnull final Environment environment )
  {
    final ConsoleHandler handler = new ConsoleHandler();
    handler.setFormatter( new RawFormatter() );
    handler.setLevel( Level.ALL );
    final Logger logger = environment.logger();
    logger.setUseParentHandlers( false );
    logger.addHandler( handler );
    logger.setLevel( Level.INFO );
  }

  static boolean processOptions( @Nonnull final Environment environment, @Nonnull final String... args )
  {
    // Parse the arguments
    final CLArgsParser parser =
      new CLArgsParser( args, OPTIONS, lastOptionCode -> CLOption.TEXT_ARGUMENT == lastOptionCode );

    //Make sure that there was no errors parsing arguments
    final Logger logger = environment.logger();
    if ( null != parser.getErrorString() )
    {
      logger.log( Level.SEVERE, "Error: " + parser.getErrorString() );
      return false;
    }
    // Retrieve run directory first as some of the other options are interpreted relative to current directory
    for ( final CLOption option : parser.getArguments() )
    {
      if ( DIR_OPT == option.getId() )
      {
        final String argument = option.getArgument();
        final Path directory = environment.currentDirectory().resolve( argument ).toAbsolutePath().normalize();
        if ( !Files.exists( directory ) )
        {
          logger.log( Level.SEVERE,
                      "Error: Specified directory does not exist. Specified value: " + argument );
          return false;
        }
        if ( !Files.isDirectory( directory ) )
        {
          logger.log( Level.SEVERE,
                      "Error: Specified directory is not a directory. Specified value: " + argument );
          return false;
        }
        environment.setCurrentDirectory( directory );
      }
    }
    // Get a list of parsed options
    for ( final CLOption option : parser.getArguments() )
    {
      switch ( option.getId() )
      {
        case CLOption.TEXT_ARGUMENT:
        {
          final String command = option.getArgument();
          if ( !COMMAND_MAP.containsKey( command ) )
          {
            logger.log( Level.SEVERE, "Error: Unknown command: " + command );
            return false;
          }
          else if ( environment.hasCommand() )
          {
            logger.log( Level.SEVERE, "Error: Duplicate command specified: " + command );
            return false;
          }
          environment.setCommand( COMMAND_MAP.get( command ).get() );
          break;
        }
        case DIR_OPT:
        {
          break;
        }

        case VERBOSE_OPT:
        {
          logger.setLevel( Level.ALL );
          break;
        }
        case QUIET_OPT:
        {
          logger.setLevel( Level.WARNING );
          break;
        }
        case VERSION_OPT:
        {
          environment.logger().log( Level.WARNING, "Webtack Version: " + WebtackConfig.getVersion() );
          return false;
        }
        case HELP_OPT:
        {
          printUsage( environment );
          return false;
        }
      }
    }

    if ( !environment.hasCommand() )
    {
      logger.log( Level.SEVERE, "Error: No command specified. Please specify a command." );
      return false;
    }
    final String[] unParsedArgs = parser.getUnParsedArgs();
    if ( unParsedArgs.length > 0 )
    {
      if ( !environment.getCommand().processOptions( environment, unParsedArgs ) )
      {
        return false;
      }
    }

    if ( environment.hasConfigFile() && environment.getCommand().requireConfigFile() )
    {
      if ( !environment.getConfigFile().toFile().exists() )
      {
        logger.log( Level.SEVERE,
                    "Error: Specified config file does not exist. Specified value: " + environment.getConfigFile() );
        return false;
      }
    }

    if ( !environment.hasConfigFile() )
    {
      final Path configFile =
        environment.currentDirectory().resolve( RepositoryConfig.FILENAME ).toAbsolutePath().normalize();
      if ( environment.getCommand().requireConfigFile() && !configFile.toFile().exists() )
      {
        logger.log( Level.SEVERE,
                    "Error: Default config file does not exist: " + RepositoryConfig.FILENAME );
        return false;
      }
      environment.setConfigFile( configFile );
    }
    return true;
  }

  /**
   * Print out a usage statement
   */
  static void printUsage( @Nonnull final Environment environment )
  {
    final Logger logger = environment.logger();
    logger.severe( "java " + Main.class.getName() + " [options] [command]" );
    logger.severe( "\tPossible Commands:" );
    for ( final Map.Entry<String, Supplier<Command>> entry : COMMAND_MAP.entrySet() )
    {
      logger.severe( "\t\t" + entry.getKey() + ": " + entry.getValue().get().getHelp() );
    }
    logger.severe( "\tOptions:" );
    final String[] options =
      CLUtil.describeOptions( OPTIONS ).toString().split( System.getProperty( "line.separator" ) );
    for ( final String line : options )
    {
      logger.severe( line );
    }
  }
}
