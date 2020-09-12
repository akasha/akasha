package org.realityforge.webtack.model.tools.processors.rename_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RenameType" )
public final class RenameTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public String replacement;
  public int expectedRenameCount;

  @Nonnull
  @Override
  public Processor create( @Nonnull final PipelineContext context )
  {
    return new RenameTypeProcessor( context,
                                    requirePattern( "namePattern", namePattern ),
                                    requireNonNull( "replacement", replacement ),
                                    expectedRenameCount);
  }
}
