package org.realityforge.webtack;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.model.SourceInterval;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.merger.SchemaJoiner;
import org.realityforge.webtack.model.tools.merger.SchemaJoinerRegistry;
import org.realityforge.webtack.model.tools.pipeline.ExecutionContext;
import org.realityforge.webtack.model.tools.pipeline.InvalidFormatException;
import org.realityforge.webtack.model.tools.pipeline.ParseError;
import org.realityforge.webtack.model.tools.pipeline.Pipeline;
import org.realityforge.webtack.model.tools.pipeline.SourceIOException;
import org.realityforge.webtack.model.tools.pipeline.SourceNotFetchedException;
import org.realityforge.webtack.model.tools.pipeline.UnexpectedSourceException;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;
import org.realityforge.webtack.model.tools.transform.SchemaProcessor;
import org.realityforge.webtack.model.tools.transform.SchemaProcessorRegistry;
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
      //TODO: Get pipline name here
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();

    final Pipeline pipeline = loadPipeline( context );

    final List<WebIDLSchema> schemas;
    try
    {
      schemas = pipeline.loadSchemas();
    }
    catch ( final SourceNotFetchedException e )
    {
      final String message =
        "Error: Attempting to parse source with the name '" + e.getSource().getName() +
        "' but the source has not been fetched.";
      logger.log( Level.SEVERE, message );
      return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
    }
    catch ( final InvalidFormatException e )
    {
      final List<ParseError> errors = e.getErrors();
      for ( final ParseError error : errors )
      {
        System.err.println( "syntax error: " +
                            e.getSource().getName() + ":" +
                            error.getLine() + ":" +
                            error.getCharPositionInLine() + " " +
                            error.getMessage() );
      }
      final String message =
        "Error: Attempting to parse source named '" + e.getSource().getName() + "' but there was " +
        errors.size() + " error(s) detected while parsing the WebIDL";
      logger.log( Level.SEVERE, message );
      return ExitCodes.ERROR_IDL_NOT_VALID_CODE;
    }
    catch ( final SourceIOException e )
    {
      final String message =
        "Error: Attempting to parse source with the name '" + e.getSource().getName() + "' but there was an error " +
        "reading WebIDL for source. Error: " + e.getCause();
      logger.log( Level.SEVERE, message );
      return ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE;
    }
    catch ( final UnexpectedSourceException e )
    {
      final String message =
        "Error: Attempting to parse source with the name '" + e.getSource().getName() +
        "' but there was an unexpected error verifying source. Error: " + e.getCause();
      logger.log( Level.SEVERE, message, e.getCause() );
      return ExitCodes.ERROR_EXIT_CODE;
    }

    final SchemaJoiner joiner =
      SchemaJoinerRegistry.createSchemaProcessor( "Merge", Json.createObjectBuilder().build() );
    final WebIDLSchema mergedSchema = joiner.merge( schemas.toArray( new WebIDLSchema[ 0 ] ) );
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
      final SchemaProcessor p1 =
        SchemaProcessorRegistry.createSchemaProcessor( "RemoveIncludes",
                                                       Json.createObjectBuilder()
                                                         .add( "interfacePattern", "^SVGAElement$" )
                                                         .add( "mixinPattern", "^SVGURIReference$" )
                                                         .build() );
      final SchemaProcessor p2 =
        SchemaProcessorRegistry.createSchemaProcessor( "ExtractExposureSet",
                                                       Json.createObjectBuilder()
                                                         .add( "globalInterface", "Window" )
                                                         .build() );
      final SchemaProcessor p3 =
        SchemaProcessorRegistry.createSchemaProcessor( "Flatten",
                                                       Json.createObjectBuilder().build() );

      final WebIDLSchema flattenSchema = p3.transform( p2.transform( p1.transform( mergedSchema ) ) );
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
  }

  @Nonnull
  private Pipeline loadPipeline( @Nonnull final Context context )
  {
    final RepositoryConfig config = context.config();
    final PipelineConfig pipeline = new PipelineConfig();
    pipeline.setName( "main" );
    return new Pipeline( config,
                         pipeline,
                         new ExecutionContext( context.environment().webidlDirectory(),
                                               new ProgressListener( context.environment().logger() ) ) );
  }

  private static class ProgressListener
    implements org.realityforge.webtack.model.tools.pipeline.ProgressListener
  {
    private final Logger _logger;

    public ProgressListener( @Nonnull final Logger logger )
    {
      _logger = Objects.requireNonNull( logger );
    }

    @Override
    public void onSourcesFiltered( @Nonnull final PipelineConfig pipeline, @Nonnull final List<SourceConfig> sources )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Pipeline named '" + pipeline.getName() + "' selected " + sources.size() + " sources to load" );
      }
    }

    @Override
    public void onSourceParsed( @Nonnull final PipelineConfig pipeline,
                                @Nonnull final SourceConfig source,
                                @Nonnull final WebIDLSchema schema )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Pipeline named '" + pipeline.getName() + "' parsed source named '" + source.getName() + "'" );
      }
    }

    @Override
    public void beforeStage( @Nonnull final PipelineConfig pipeline,
                             @Nonnull final StageConfig stage,
                             @Nonnull final List<WebIDLSchema> schemas )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Pipeline named '" + pipeline.getName() +
                     "' is starting stage named '" + stage.getName() + "' with " +
                     schemas.size() + " schemas as input." );
      }
    }

    @Override
    public void afterStage( @Nonnull final PipelineConfig pipeline,
                            @Nonnull final StageConfig stage,
                            @Nonnull final List<WebIDLSchema> schemas )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Pipeline named '" + pipeline.getName() +
                     "' completed stage named '" + stage.getName() + "' with " +
                     schemas.size() + " schemas as output." );
      }
    }
  }
}
