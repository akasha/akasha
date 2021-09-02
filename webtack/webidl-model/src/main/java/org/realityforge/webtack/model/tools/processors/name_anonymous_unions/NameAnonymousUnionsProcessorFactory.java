package org.realityforge.webtack.model.tools.processors.name_anonymous_unions;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

/**
 * Processor to typedef unions that are return types or attribute/member types with a name.
 */
@Name( "NameAnonymousUnions" )
public final class NameAnonymousUnionsProcessorFactory
  extends AbstractProcessorFactory
{
  public int expectedChangeCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new NameAnonymousUnionsProcessor( context, expectedChangeCount );
  }
}
