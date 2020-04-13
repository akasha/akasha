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
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.config.RepositoryConfig;
import org.realityforge.webtack.config.SourceConfig;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;

final class VerifyCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "verify";
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
    };
  @Nonnull
  private final Set<String> _sourceNames = new LinkedHashSet<>();

  VerifyCommand()
  {
    super( COMMAND, "Verify that the WebIDL source can be parsed and is syntactically valid", OPTIONS );
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
        final CountingConsoleErrorListener errorListener = new CountingConsoleErrorListener();
        @SuppressWarnings( "unused" )
        final WebIDLSchema schema = WebIDLModelParser.parse( sourceName, reader, errorListener );

        final int errorCount = errorListener.getErrorCount();
        if ( 0 == errorCount )
        {
          if ( logger.isLoggable( Level.INFO ) )
          {
            logger.log( Level.INFO, "Source named '" + sourceName + "' verified" );
          }
        }
        else
        {
          final String message =
            "Error: Attempting to verify source named '" + sourceName + "' but there was " + errorCount +
            " errors detected in the WebIDL";
          logger.log( Level.SEVERE, message );
          return ExitCodes.ERROR_IDL_NOT_VALID_CODE;
        }
      }
      catch ( final IOException ioe )
      {
        final String message =
          "Error: Attempting to verify source with the name '" + sourceName + "' but there was an error " +
          "reading WebIDL for source. Error: " + ioe;
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }
      catch ( final Throwable t )
      {
        final String message =
          "Error: Attempting to verify source with the name '" + sourceName +
          "' but there was an unexpected error verifying source. Error: " + t;
        logger.log( Level.SEVERE, message, t );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }
    }
    return ExitCodes.SUCCESS_EXIT_CODE;
  }

  private static class CountingConsoleErrorListener
    extends ConsoleErrorListener
  {
    private int _errorCount;

    @Override
    public void syntaxError( final Recognizer<?, ?> recognizer,
                             final Object offendingSymbol,
                             final int line,
                             final int charPositionInLine,
                             final String msg,
                             final RecognitionException e )
    {
      super.syntaxError( recognizer, offendingSymbol, line, charPositionInLine, msg, e );
      _errorCount++;
    }

    int getErrorCount()
    {
      return _errorCount;
    }
  }
}
