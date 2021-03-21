package org.realityforge.webtack.model.tools.processors.remove_element;

import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RemoveElement" )
public final class RemoveElementProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public List<ElementType> types;
  public int expectedRemoveCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RemoveElementProcessor( context,
                                       requirePattern( "namePattern", namePattern ),
                                       types,
                                       expectedRemoveCount );
  }
}
