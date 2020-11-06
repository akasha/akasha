package org.realityforge.webtack.model.tools.processors.change_extends;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ChangeExtends" )
public final class ChangeExtendsProcessorFactory
  extends AbstractProcessorFactory
{
  public String elementNamePattern;
  public String parentType;
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ChangeExtendsProcessor( context,
                                       requirePattern( "elementNamePattern", elementNamePattern ),
                                       requireNonNull( "parentType", parentType ),
                                       expectedChangeCount );
  }
}
