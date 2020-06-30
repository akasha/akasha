package org.realityforge.webtack.model.tools.processors.rename_enumeration;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RenameEnumeration" )
public final class RenameEnumerationProcessorFactory
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
      throw new IllegalArgumentException( "RenameEnumerationProcessor missing required namePattern configuration value" );
    }
    if ( null == replacement )
    {
      throw new IllegalArgumentException( "RenameEnumerationProcessor missing required replacement configuration value" );
    }
    return new RenameEnumerationProcessor( Pattern.compile( namePattern ), replacement );
  }
}
