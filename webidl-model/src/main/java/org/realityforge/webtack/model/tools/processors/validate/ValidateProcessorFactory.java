package org.realityforge.webtack.model.tools.processors.validate;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "Validate" )
public final class ValidateProcessorFactory
  implements ProcessorFactory
{
  @Nonnull
  @Override
  public Processor create()
  {
    return new ValidateProcessor();
  }
}
