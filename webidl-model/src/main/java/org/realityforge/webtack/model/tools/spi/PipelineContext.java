package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;

public interface PipelineContext
{
  @Nonnull
  DocRepositoryRuntime docRepository();
}
