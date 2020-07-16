package org.realityforge.webtack.model.tools.processors.rename_type;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;

@Name( "RenameType" )
public final class RenameTypeProcessorFactory
  extends AbstractProcessorFactory
{
  public String namePattern;
  public String replacement;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RenameTypeProcessor( requirePattern( "namePattern", namePattern ),
                                    requireNonNull( "replacement", replacement ) );
  }
}
