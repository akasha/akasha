package org.realityforge.webtack.model.tools.processors.rename_type;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RenameType" )
public final class RenameTypeProcessorFactory
  implements ProcessorFactory
{
  public String namePattern;
  public String replacement;

  @Nonnull
  @Override
  public Processor create()
  {
    if ( null == namePattern )
    {
      throw new IllegalArgumentException( "RenameTypeProcessor missing required namePattern configuration value" );
    }
    if ( null == replacement )
    {
      throw new IllegalArgumentException( "RenameTypeProcessor missing required replacement configuration value" );
    }
    return new RenameTypeProcessor( Pattern.compile( namePattern ), replacement );
  }
}
