package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;

public interface ProcessorFactory
{
  @Nonnull
  Processor create( @Nonnull PipelineContext context );
}
