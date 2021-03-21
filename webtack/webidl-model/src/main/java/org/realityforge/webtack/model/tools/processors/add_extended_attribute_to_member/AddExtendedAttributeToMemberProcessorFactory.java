package org.realityforge.webtack.model.tools.processors.add_extended_attribute_to_member;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "AddExtendedAttributeToMember" )
public final class AddExtendedAttributeToMemberProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String memberNamePattern;
  public String extendedAttribute;
  public int expectedAddCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new AddExtendedAttributeToMemberProcessor( context,
                                                      requirePattern( "elementNamePattern", elementNamePattern ),
                                                      requirePattern( "memberNamePattern", memberNamePattern ),
                                                      requireExtendedAttribute( "extendedAttribute",
                                                                                extendedAttribute ),
                                                      expectedAddCount );
  }
}
