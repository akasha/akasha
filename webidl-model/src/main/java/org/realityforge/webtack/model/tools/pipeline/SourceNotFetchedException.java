package org.realityforge.webtack.model.tools.pipeline;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public class SourceNotFetchedException
  extends SourceException
{
  public SourceNotFetchedException( @Nonnull final PipelineConfig pipeline, @Nonnull final SourceConfig source )
  {
    super( pipeline, source );
  }
}
