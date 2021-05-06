package org.realityforge.webtack.model.tools.processors.extend_object;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "ExtendObject" )
public final class ExtendObjectProcessorFactory
  extends AbstractProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new ExtendObjectProcessor( context );
  }
}
