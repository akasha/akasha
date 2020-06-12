package org.realityforge.webtack.model.tools.pipeline;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;

public final class StageProcessException
  extends StageException
{
  public StageProcessException( @Nonnull final PipelineConfig pipeline,
                                @Nonnull final StageConfig source,
                                @Nonnull final Throwable cause )
  {
    super( pipeline, source, Objects.requireNonNull( cause ) );
  }
}
