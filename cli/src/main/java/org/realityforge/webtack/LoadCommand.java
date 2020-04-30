package org.realityforge.webtack;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.config.RepositoryConfig;
import org.realityforge.webtack.config.SourceConfig;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.merger.MergerTool;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.model.tools.validator.Validator;
import org.realityforge.webtack.model.tools.validator.ValidatorTool;

final class LoadCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "load";
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
    };
  @Nonnull
  private final Set<String> _sourceNames = new LinkedHashSet<>();

  LoadCommand()
  {
    super( COMMAND, "Load that the WebIDL source and verify that it is semantically valid", OPTIONS );
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
    final List<WebIDLSchema> schemas = new ArrayList<>();
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
        logger.log( Level.INFO, "Parsing source named '" + sourceName + "'" );
      }
      final SourceConfig source = config.findSourceByName( sourceName );
      if ( null == source )
      {
        final String message =
          "Error: Attempting to parse source with the name '" + sourceName + "' but no such source exists.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_DOES_NOT_EXIST_CODE;
      }

      final Path target = context.environment().getPathForSource( source );
      if ( !Files.exists( target ) )
      {
        final String message =
          "Error: Attempting to parse source with the name '" + sourceName + "' but the source has not been fetched.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }

      try ( final FileReader reader = new FileReader( target.toFile() ) )
      {
        final CountingConsoleErrorListener errorListener = new CountingConsoleErrorListener( target.toString() );
        final WebIDLSchema schema = WebIDLModelParser.parse( sourceName, reader, errorListener );
        schemas.add( schema );

        final int errorCount = errorListener.getErrorCount();
        if ( 0 == errorCount )
        {
          if ( logger.isLoggable( Level.INFO ) )
          {
            logger.log( Level.INFO, "Source named '" + sourceName + "' parsed" );
          }
        }
        else
        {
          final String message =
            "Error: Attempting to parse source named '" + sourceName + "' but there was " + errorCount +
            " errors detected in the WebIDL";
          logger.log( Level.SEVERE, message );
          return ExitCodes.ERROR_IDL_NOT_VALID_CODE;
        }
      }
      catch ( final IOException ioe )
      {
        final String message =
          "Error: Attempting to parse source with the name '" + sourceName + "' but there was an error " +
          "reading WebIDL for source. Error: " + ioe;
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }
      catch ( final Throwable t )
      {
        final String message =
          "Error: Attempting to parse source with the name '" + sourceName +
          "' but there was an unexpected error verifying source. Error: " + t;
        logger.log( Level.SEVERE, message, t );
        return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
      }
    }
    final MergerTool mergerTool = new MergerTool();
    final WebIDLSchema mergedSchema = mergerTool.merge( schemas.toArray( new WebIDLSchema[ 0 ] ) );
    final Validator validator = ValidatorTool.create();
    final Collection<ValidationError> errors = validator.validate( mergedSchema );
    if ( !errors.isEmpty() )
    {
      for ( final ValidationError error : errors )
      {
        final List<SourceInterval> sourceLocations = error.getNode().getSourceLocations();
        final String prefix = sourceLocations.isEmpty() ? "" : sourceLocations.get( 0 ).getStart().toString() + " ";
        logger.log( error.shouldHalt() ? Level.SEVERE : Level.WARNING, prefix + error.getMessage() );
      }
      return ExitCodes.ERROR_SCHEMA_INVALID_CODE;
    }
    else
    {
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
  }
}
