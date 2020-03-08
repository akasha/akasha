package org.realityforge.webtack;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLArgsParser;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.getopt4j.CLUtil;

abstract class ConfigurableCommand
  extends Command
{
  private static final int HELP_OPT = 'h';
  private static final CLOptionDescriptor HELP_DESCRIPTOR =
    new CLOptionDescriptor( "help",
                            CLOptionDescriptor.ARGUMENT_DISALLOWED,
                            HELP_OPT,
                            "print this message and exit" );
  @Nonnull
  private final CLOptionDescriptor[] _options;

  ConfigurableCommand( @Nonnull final String name,
                       @Nonnull final String help,
                       @Nonnull final CLOptionDescriptor[] options )
  {
    super( name, help );
    _options = new CLOptionDescriptor[ options.length + 1 ];
    _options[ 0 ] = HELP_DESCRIPTOR;
    System.arraycopy( options, 0, _options, 1, options.length );
  }

  @Override
  final boolean processOptions( @Nonnull final Environment environment, @Nonnull final String... args )
  {
    // Parse the arguments
    final CLArgsParser parser = new CLArgsParser( args, _options );

    //Make sure that there was no errors parsing arguments
    final Logger logger = environment.logger();
    if ( null != parser.getErrorString() )
    {
      logger.log( Level.SEVERE, "Error: " + parser.getErrorString() );
      return false;
    }
    // Get a list of parsed options
    final List<CLOption> arguments = parser.getArguments();
    final ArrayList<CLOption> argumentsToProcess = new ArrayList<>( arguments );
    for ( final CLOption option : arguments )
    {
      if ( HELP_OPT == option.getId() )
      {
        argumentsToProcess.remove( option );
        printUsage( environment );
        return false;
      }
    }
    return processArguments( environment, argumentsToProcess );
  }

  abstract boolean processArguments( @Nonnull Environment environment,
                                     @Nonnull List<CLOption> arguments );

  /**
   * Print out a usage statement
   */
  private void printUsage( @Nonnull final Environment environment )
  {
    final Logger logger = environment.logger();
    logger.info( getName() + " Options:" );
    final String[] options =
      CLUtil.describeOptions( _options ).toString().split( System.getProperty( "line.separator" ) );
    for ( final String line : options )
    {
      logger.info( line );
    }
  }
}
