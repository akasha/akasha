package org.realityforge.webtack.model.tools.processors.remove_member;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RemoveMember" )
public final class RemoveMemberProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String memberNamePattern;
  public List<ElementType> types;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RemoveMemberProcessor( requirePattern( "elementNamePattern", elementNamePattern ),
                                      requirePattern( "memberNamePattern", memberNamePattern ),
                                      types );
  }
}
