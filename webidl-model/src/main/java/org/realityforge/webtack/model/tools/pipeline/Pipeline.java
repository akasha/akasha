package org.realityforge.webtack.model.tools.pipeline;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.Json;
import javax.json.JsonObject;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.PipelineContextImpl;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;
import org.realityforge.webtack.model.tools.spi.Action;
import org.realityforge.webtack.model.tools.spi.Combiner;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;

public final class Pipeline
{
  @Nonnull
  private final RepositoryConfig _repository;
  @Nonnull
  private final PipelineConfig _pipeline;
  @Nonnull
  private final ExecutionContext _context;
  @Nonnull
  private final PipelineContextImpl _pipelineContext;

  public Pipeline( @Nonnull final RepositoryConfig repository,
                   @Nonnull final PipelineConfig pipeline,
                   @Nonnull final ExecutionContext context )
  {
    _repository = Objects.requireNonNull( repository );
    _pipeline = Objects.requireNonNull( pipeline );
    _context = Objects.requireNonNull( context );
    _pipelineContext = new PipelineContextImpl( new DocRepositoryRuntime( context.getDocDirectory() ) );
  }

  @Nonnull
  public RepositoryConfig getRepository()
  {
    return _repository;
  }

  @Nonnull
  public PipelineConfig getConfig()
  {
    return _pipeline;
  }

  @Nonnull
  public PipelineContextImpl getPipelineContext()
  {
    return _pipelineContext;
  }

  public void process()
    throws PipelineException
  {
    processSchemas( loadSchemas() );
  }

  void processSchemas( @Nonnull final List<WebIDLSchema> initialSchemas )
    throws PipelineException
  {
    final List<WebIDLSchema> current = new ArrayList<>( initialSchemas );

    final List<StageConfig> stages = _pipeline.getStages();
    for ( final StageConfig stage : stages )
    {
      final String name = stage.getName();
      _context.getProgressListener().beforeStage( _pipeline, stage, current );

      final String selector = stage.getSourceSelector();
      final List<WebIDLSchema> resultSchema = new ArrayList<>();

      if ( Registry.isCombinerPresent( name ) )
      {
        final Combiner processor = Registry.createCombiner( _pipelineContext, name, getStageConfig( stage ) );
        final List<WebIDLSchema> matchedSchema = new ArrayList<>();
        final List<WebIDLSchema> unmatchedSchema = new ArrayList<>();
        for ( final WebIDLSchema schema : current )
        {
          if ( isSchemaSelected( schema, selector ) )
          {
            matchedSchema.add( schema );
          }
          else
          {
            unmatchedSchema.add( schema );
          }
        }
        try
        {
          resultSchema.add( processor.combine( matchedSchema.toArray( new WebIDLSchema[ 0 ] ) ) );
        }
        catch ( final Exception e )
        {
          throw new StageProcessException( _pipeline, stage, e );
        }
        resultSchema.addAll( unmatchedSchema );
      }
      else if ( Registry.isProcessorPresent( name ) )
      {
        final Processor processor =
          Registry.createProcessor( name, getStageConfig( stage ) );
        for ( final WebIDLSchema schema : current )
        {
          if ( isSchemaSelected( schema, selector ) )
          {
            try
            {
              final WebIDLSchema output = processor.process( schema );
              if ( null != output )
              {
                resultSchema.add( output );
              }
            }
            catch ( final Exception e )
            {
              throw new StageProcessException( _pipeline, stage, e );
            }
          }
          else
          {
            resultSchema.add( schema );
          }
        }
      }
      else if ( Registry.isActionPresent( name ) )
      {
        final Action action = Registry.createAction( _pipelineContext, name, getStageConfig( stage ) );
        for ( final WebIDLSchema schema : current )
        {
          if ( isSchemaSelected( schema, selector ) )
          {
            try
            {
              action.process( schema );
            }
            catch ( final Exception e )
            {
              throw new StageProcessException( _pipeline, stage, e );
            }
          }
          resultSchema.add( schema );
        }
      }
      else
      {
        throw new UnknownStageConfigException( _pipeline, stage );
      }
      current.clear();
      current.addAll( resultSchema );
      _context.getProgressListener().afterStage( _pipeline, stage, current );
    }
  }

  private boolean isSchemaSelected( @Nonnull final WebIDLSchema schema, @Nullable final String selector )
  {
    return null == selector || matchSelector( selector, schema.getTags() );
  }

  @Nonnull
  private JsonObject getStageConfig( @Nonnull final StageConfig stage )
  {
    final JsonObject config = stage.getConfig();
    return null == config ? Json.createObjectBuilder().build() : config;
  }

  @Nonnull
  List<WebIDLSchema> loadSchemas()
    throws SourceNotFetchedException, SourceIOException, UnexpectedSourceException, InvalidFormatException
  {
    final List<WebIDLSchema> schemas = new ArrayList<>();
    final List<SourceConfig> sources =
      _repository.getSources().stream().filter( this::includeSource ).collect( Collectors.toList() );
    final ProgressListener progressListener = _context.getProgressListener();
    progressListener.onSourcesFiltered( _pipeline, sources );
    for ( final SourceConfig source : sources )
    {
      schemas.add( loadSchema( source, progressListener ) );
    }
    return schemas;
  }

  @Nonnull
  private WebIDLSchema loadSchema( @Nonnull final SourceConfig source,
                                   @Nonnull final ProgressListener progressListener )
    throws SourceNotFetchedException, SourceIOException, UnexpectedSourceException, InvalidFormatException
  {
    final ParseErrorCollector errorCollector = new ParseErrorCollector();
    final WebIDLSchema schema = parseSchema( source, errorCollector );

    final List<ParseError> errors = errorCollector.getErrors();
    if ( errors.isEmpty() )
    {
      assert null != schema;
      progressListener.onSourceParsed( _pipeline, source, schema );
      return schema;
    }
    else
    {
      throw new InvalidFormatException( _pipeline, source, errors );
    }
  }

  @Nullable
  private WebIDLSchema parseSchema( @Nonnull final SourceConfig source,
                                    @Nonnull final ParseErrorCollector errorCollector )
    throws SourceNotFetchedException, SourceIOException, UnexpectedSourceException
  {
    final String sourceName = source.getName();
    final Path sourcePath = _context.getWebidlDirectory().resolve( sourceName + WebIDLSchema.EXTENSION );
    if ( !Files.exists( sourcePath ) )
    {
      throw new SourceNotFetchedException( _pipeline, source );
    }
    final Set<String> tags = new HashSet<>();
    final List<String> sourceTags = source.getTags();
    if ( null != sourceTags )
    {
      tags.addAll( sourceTags );
    }
    tags.add( "name=" + source.getName() );
    try ( final FileReader reader = new FileReader( sourcePath.toFile() ) )
    {
      return WebIDLModelParser.parse( sourceName, tags, reader, errorCollector );
    }
    catch ( final IOException ioe )
    {
      throw new SourceIOException( _pipeline, source, ioe );
    }
    catch ( final ParseCancellationException pce )
    {
      return null;
    }
    catch ( final Throwable t )
    {
      throw new UnexpectedSourceException( _pipeline, source, t );
    }
  }

  private boolean includeSource( @Nonnull final SourceConfig source )
  {
    final String selector = _pipeline.getSourceSelector();
    if ( null == selector )
    {
      return true;
    }
    else
    {
      final List<String> declaredTags = source.getTags();
      final Set<String> tags = new HashSet<>();
      if ( null != declaredTags )
      {
        tags.addAll( declaredTags );
      }
      tags.add( "name=" + source.getName() );
      return matchSelector( selector, tags );
    }
  }

  private boolean matchSelector( @Nonnull final String selector, @Nonnull final Set<String> tags )
  {
    boolean defaultMatch = true;
    for ( final String tag : selector.split( " +" ) )
    {
      if ( tag.startsWith( "!" ) )
      {
        if ( tags.contains( tag.substring( 1 ) ) )
        {
          return false;
        }
      }
    }

    for ( final String tag : selector.split( " +" ) )
    {
      if ( !tag.startsWith( "!" ) )
      {
        defaultMatch = false;
        if ( tags.contains( tag ) )
        {
          return true;
        }
      }
    }
    return defaultMatch;
  }
}
