package org.realityforge.webtack.model.tools.processors.change_attribute_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ChangeAttributeType" )
public final class ChangeAttributeTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String attributeNamePattern;
  public String type;
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ChangeAttributeTypeProcessor( context,
                                             requirePattern( "elementNamePattern", elementNamePattern ),
                                             requirePattern( "attributeNamePattern", attributeNamePattern ),
                                             requireType( "type", type ),
                                             expectedChangeCount );
  }
}
