package org.realityforge.webtack.model.tools.pipeline;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public final class UnexpectedSourceException
  extends SourceException
{
  public UnexpectedSourceException( @Nonnull final PipelineConfig pipeline,
                                    @Nonnull final SourceConfig source,
                                    @Nonnull final Throwable cause )
  {
    super( pipeline, source, cause );
  }
}
