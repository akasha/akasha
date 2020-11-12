package org.realityforge.webtack.model.tools.processors.synthesize_transferable;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "SynthesizeTransferable" )
public final class SynthesizeTransferableProcessorFactory
  extends AbstractProcessorFactory
{
  public int expectedTransferableCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new SynthesizeTransferableProcessor( context, expectedTransferableCount );
  }
}
