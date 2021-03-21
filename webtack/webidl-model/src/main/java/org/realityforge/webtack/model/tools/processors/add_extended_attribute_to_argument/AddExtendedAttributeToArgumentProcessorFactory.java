package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_argument;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "AddExtendedAttributeToArgument" )
public final class AddExtendedAttributeToArgumentProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String operationNamePattern;
  public String argumentNamePattern;
  public String extendedAttribute;
  public int expectedAddCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new AddExtendedAttributeToArgumentProcessor( context,
                                                        requirePattern( "elementNamePattern", elementNamePattern ),
                                                        requirePattern( "operationNamePattern", operationNamePattern ),
                                                        requirePattern( "argumentNamePattern", argumentNamePattern ),
                                                        requireExtendedAttribute( "extendedAttribute",
                                                                                  extendedAttribute ),
                                                        expectedAddCount );
  }
}
