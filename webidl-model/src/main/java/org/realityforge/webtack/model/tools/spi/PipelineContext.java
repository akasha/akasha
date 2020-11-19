package org.realityforge.webtack.model.tools.spi;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.pipeline.config.StageConfig;

public interface PipelineContext
{
  @Nonnull
  DocRepositoryRuntime docRepository();

  void beforeStage( @Nonnull StageConfig stage, @Nonnull List<WebIDLSchema> schemas );

  void debug( @Nonnull String message );

  void info( @Nonnull String message );

  void error( @Nonnull String message );

  void afterStage( @Nonnull StageConfig stage, @Nonnull List<WebIDLSchema> schemas );
}
