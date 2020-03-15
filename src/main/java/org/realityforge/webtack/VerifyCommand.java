package org.realityforge.webtack;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.config.RepositoryConfig;
import org.realityforge.webtack.config.SourceConfig;
import org.realityforge.webtack.webidl.parser.WebIDLBaseListener;
import org.realityforge.webtack.webidl.parser.WebIDLLexer;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

final class VerifyCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "verify";
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
    };
  @Nonnull
  private Set<String> _sourceNames = new LinkedHashSet<>();

  VerifyCommand()
  {
    super( COMMAND, "Verify that the WebIDL source can be parsed", OPTIONS );
  }

  @Override
  boolean processArguments( @Nonnull final Environment environment, @Nonnull final List<CLOption> arguments )
  {
    for ( final CLOption option : arguments )
    {
      assert CLOption.TEXT_ARGUMENT == option.getId();
      _sourceNames.add( option.getArgument() );
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();

    final RepositoryConfig config = context.config();

    final Set<String> sourceNames = _sourceNames.isEmpty() ?
                                    config.getSources()
                                      .stream()
                                      .map( SourceConfig::getName )
                                      .collect( Collectors.toCollection( LinkedHashSet::new ) ) :
                                    _sourceNames;
    for ( final String sourceName : sourceNames )
    {
      if ( logger.isLoggable( Level.INFO ) )
      {
        logger.log( Level.INFO, "Verifying source named '" + sourceName + "'" );
      }
      final SourceConfig source = config.findSourceByName( sourceName );
      if ( null == source )
      {
        final String message =
          "Error: Attempting to verify source with the name '" + sourceName + "' but no such source exists.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_DOES_NOT_EXIST_CODE;
      }

      final Path target = context.environment().getPathForSource( source );
      if ( !Files.exists( target ) )
      {
        final String message =
          "Error: Attempting to verify source with the name '" + sourceName + "' but the source has not been fetched.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }

      try ( final FileReader reader = new FileReader( target.toFile() ) )
      {
        final ANTLRInputStream input = new ANTLRInputStream( reader );
        final WebIDLLexer lexer = new BailLexer( input );
        final CommonTokenStream tokens = new CommonTokenStream( lexer );
        final WebIDLParser parser = new WebIDLParser( tokens );
        parser.setBuildParseTree( true );
        final ParseListener listener = new ParseListener();
        parser.addParseListener( listener );
        parser.setErrorHandler( new BailErrorStrategy() );

        final WebIDLParser.WebIDLContext webIDLContext = parser.webIDL();

        if ( logger.isLoggable( Level.INFO ) )
        {
          logger.log( Level.INFO, "Source named '" + sourceName + "' verified" );
        }
      }
      catch ( final IOException ioe )
      {
        final String message =
          "Error: Attempting to verify source with the name '" + sourceName + "' but there was an error " +
          "reading source. Error: " + ioe;
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }
    }
    return ExitCodes.SUCCESS_EXIT_CODE;
  }

  private static class BailLexer
    extends WebIDLLexer
  {
    public BailLexer( final CharStream input )
    {
      super( input );
    }

    public void recover( final LexerNoViableAltException e )
    {
      throw new ParseCancellationException( e );
    }
  }

  private static class ParseListener
    extends WebIDLBaseListener
  {
  }

}
