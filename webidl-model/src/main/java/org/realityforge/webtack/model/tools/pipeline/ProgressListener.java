package org.realityforge.webtack.model.tools.pipeline;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public interface ProgressListener
{
  void onSourcesFiltered( @Nonnull PipelineConfig pipeline, @Nonnull List<SourceConfig> sources );

  void onSourceParsed( @Nonnull PipelineConfig pipeline, @Nonnull SourceConfig source, @Nonnull WebIDLSchema schema );
}
