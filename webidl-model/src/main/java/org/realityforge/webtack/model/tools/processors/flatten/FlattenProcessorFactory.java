package org.realityforge.webtack.model.tools.processors.flatten;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "Flatten" )
public final class FlattenProcessorFactory
  implements ProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new FlattenProcessor();
  }
}
