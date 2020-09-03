package org.realityforge.webtack.model.tools.processors.convert_constructor_attribute;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ConvertConstructorAttribute" )
public final class ConvertConstructorAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ConvertConstructorAttributeProcessor();
  }
}
