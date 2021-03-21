package org.realityforge.webtack.model.tools.pipeline;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public interface ProgressListener
{
  void onSourcesFiltered( @Nonnull PipelineConfig pipeline, @Nonnull List<SourceConfig> sources );

  void onSourceParsed( @Nonnull PipelineConfig pipeline, @Nonnull SourceConfig source, @Nonnull WebIDLSchema schema );

  void beforeStage( @Nonnull PipelineConfig pipeline, @Nonnull StageConfig stage, @Nonnull List<WebIDLSchema> schemas );

  void stageDebug( @Nonnull PipelineConfig pipeline, @Nonnull StageConfig stage, @Nonnull String message );

  void stageInfo( @Nonnull PipelineConfig pipeline, @Nonnull StageConfig stage, @Nonnull String message );

  void stageError( @Nonnull PipelineConfig pipeline, @Nonnull StageConfig stage, @Nonnull String message );

  void afterStage( @Nonnull PipelineConfig pipeline, @Nonnull StageConfig stage, @Nonnull List<WebIDLSchema> schemas );
}
