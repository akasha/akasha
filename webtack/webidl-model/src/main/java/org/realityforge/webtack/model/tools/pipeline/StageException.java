package org.realityforge.webtack.model.tools.pipeline;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;

public abstract class StageException
  extends PipelineException
{
  @Nonnull
  private final StageConfig _stage;

  protected StageException( @Nonnull final PipelineConfig pipeline, @Nonnull final StageConfig stage )
  {
    this( pipeline, stage, null );
  }

  protected StageException( @Nonnull final PipelineConfig pipeline,
                            @Nonnull final StageConfig stage,
                            @Nullable final Throwable cause )
  {
    super( pipeline, cause );
    _stage = Objects.requireNonNull( stage );
  }

  @Nonnull
  public final StageConfig getStage()
  {
    return _stage;
  }
}
