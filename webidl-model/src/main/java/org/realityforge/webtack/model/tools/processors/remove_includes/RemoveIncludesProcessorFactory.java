package org.realityforge.webtack.model.tools.processors.remove_includes;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RemoveIncludes" )
public final class RemoveIncludesProcessorFactory
  extends AbstractProcessorFactory
{
  public String interfacePattern;
  public String mixinPattern;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RemoveIncludesProcessor( requirePattern( "interfacePattern", interfacePattern ),
                                        requirePattern( "mixinPattern", mixinPattern ) );
  }
}
