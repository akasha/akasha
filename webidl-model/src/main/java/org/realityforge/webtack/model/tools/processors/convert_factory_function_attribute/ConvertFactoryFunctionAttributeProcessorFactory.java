package org.realityforge.webtack.model.tools.processors.convert_factory_function_attribute;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

/**
 * This processor creates finds LegacyFactoryFunction annotations and simulates this behaviour by creating
 * a sub-interface that extends parent interface but has the correct name. This is the best way to model this
 * in closure and java world but does produce some oddities in js world. (i.e. HTMLImageElement == new Image().__proto__)
 */
@Name( "ConvertFactoryFunctionAttribute" )
public final class ConvertFactoryFunctionAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ConvertFactoryFunctionAttributeProcessor();
  }
}
