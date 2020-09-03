package org.realityforge.webtack.model.tools.processors.remove_extended_attribute;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RemoveExtendedAttribute" )
public final class RemoveExtendedAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public String extendedAttribute;
  public List<ElementType> types;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RemoveExtendedAttributeProcessor( requirePattern( "namePattern", namePattern ),
                                                 types,
                                                 requireExtendedAttribute( "extendedAttribute", extendedAttribute ) );
  }
}
