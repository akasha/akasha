package org.realityforge.webtack.model.tools.pipeline;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;

public final class UnknownStageConfigException
  extends StageException
{
  public UnknownStageConfigException( @Nonnull final PipelineConfig pipeline, @Nonnull final StageConfig stage )
  {
    this( pipeline, stage, null );
  }

  public UnknownStageConfigException( @Nonnull final PipelineConfig pipeline,
                                      @Nonnull final StageConfig stage,
                                      @Nullable final Throwable cause )
  {
    super( pipeline, stage, cause );
  }
}
