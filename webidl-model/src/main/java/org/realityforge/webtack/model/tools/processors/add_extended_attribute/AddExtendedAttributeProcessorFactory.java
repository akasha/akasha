package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "AddExtendedAttribute" )
public final class AddExtendedAttributeProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public String extendedAttribute;
  public List<ElementType> types;

  @Nonnull
  @Override
  public Processor create()
  {
    return new AddExtendedAttributeProcessor( requirePattern( "namePattern", namePattern ),
                                              types,
                                              requireExtendedAttribute( "extendedAttribute", extendedAttribute ) );
  }
}
