package org.realityforge.webtack.model.tools.processors.flatten;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "Flatten" )
public final class FlattenProcessorFactory
  implements ProcessorFactory
{
  @Nonnull
  @Override
  public Processor create()
  {
    return new FlattenProcessor();
  }
}
