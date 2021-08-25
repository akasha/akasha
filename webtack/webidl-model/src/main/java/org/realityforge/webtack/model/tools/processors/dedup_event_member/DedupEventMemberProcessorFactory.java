package org.realityforge.webtack.model.tools.processors.dedup_event_member;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "DedupEventMember" )
public final class DedupEventMemberProcessorFactory
  implements ProcessorFactory
{
  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new DedupEventMemberProcessor( context );
  }
}
