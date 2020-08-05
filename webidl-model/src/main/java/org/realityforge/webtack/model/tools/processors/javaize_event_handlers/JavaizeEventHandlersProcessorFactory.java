package org.realityforge.webtack.model.tools.processors.javaize_event_handlers;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "JavaizeEventHandlers" )
public final class JavaizeEventHandlersProcessorFactory
  extends AbstractProcessorFactory
{
  @Nonnull
  @Override
  public Processor create()
  {
    return new JavaizeEventHandlersProcessor();
  }
}
