package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "AddExtendedAttribute" )
public final class AddExtendedAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public String extendedAttribute;
  public List<ElementType> types;
  public int expectedAddCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new AddExtendedAttributeProcessor( context,
                                              requirePattern( "namePattern", namePattern ),
                                              types,
                                              requireExtendedAttribute( "extendedAttribute", extendedAttribute ),
                                              expectedAddCount );
  }
}
