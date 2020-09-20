package org.realityforge.webtack.model.tools.processors.remove_html_constructor;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

/**
 * Remove public constructors that can not be invoked by user code
 */
@Name( "RemoveHTMLConstructor" )
public final class RemoveHTMLConstructorProcessorFactory
  extends AbstractProcessorFactory
{
  public int expectedRemoveCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RemoveHTMLConstructorProcessor( context, expectedRemoveCount );
  }
}
