package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;

public interface ActionFactory
{
  @Nonnull
  Action create( @Nonnull PipelineContext context );
}
