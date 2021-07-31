package org.realityforge.webtack.model.tools;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.pipeline.ExecutionContext;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

public final class PipelineContextImpl
  implements PipelineContext
{
  @Nonnull
  private final DocRepositoryRuntime _docRepository;
  @Nonnull
  private final ExecutionContext _context;
  @Nonnull
  private final PipelineConfig _pipeline;
  private StageConfig _stage;

  public PipelineContextImpl( @Nonnull final ExecutionContext context,
                              @Nonnull final PipelineConfig pipeline )
  {
    _context = Objects.requireNonNull( context );
    _pipeline = Objects.requireNonNull( pipeline );
    _docRepository = new DocRepositoryRuntime( context.getDocDirectory() );
  }

  @Nonnull
  @Override
  public DocRepositoryRuntime docRepository()
  {
    return _docRepository;
  }

  @Override
  public void beforeStage( @Nonnull final StageConfig stage, @Nonnull final List<WebIDLSchema> schemas )
  {
    _stage = stage;
    _context.getProgressListener().beforeStage( _pipeline, stage, schemas );
  }

  @Override
  public void afterStage( @Nonnull final StageConfig stage, @Nonnull final List<WebIDLSchema> schemas )
  {
    _context.getProgressListener().afterStage( _pipeline, stage, schemas );
    _stage = null;
  }

  @Override
  public void debug( @Nonnull final String message )
  {
    _context.getProgressListener().stageDebug( _pipeline, _stage, message );
  }

  @Override
  public void info( @Nonnull final String message )
  {
    _context.getProgressListener().stageInfo( _pipeline, _stage, message );
  }

  @Override
  public void error( @Nonnull final String message )
  {
    _context.getProgressListener().stageError( _pipeline, _stage, message );
  }

  @Nonnull
  public ExecutionContext getContext()
  {
    return _context;
  }
}
