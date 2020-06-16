package org.realityforge.webtack.model.tools.pipeline;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public final class Pipeline
{
  @Nonnull
  private final RepositoryConfig _repository;
  @Nonnull
  private final PipelineConfig _pipeline;
  @Nonnull
  private final ExecutionContext _context;

  public Pipeline( @Nonnull final RepositoryConfig repository,
                   @Nonnull final PipelineConfig pipeline,
                   @Nonnull final ExecutionContext context )
  {
    _repository = Objects.requireNonNull( repository );
    _pipeline = Objects.requireNonNull( pipeline );
    _context = Objects.requireNonNull( context );
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
    return null == selector;
  }
}
