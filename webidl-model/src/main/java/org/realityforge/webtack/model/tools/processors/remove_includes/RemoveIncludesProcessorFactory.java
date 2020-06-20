package org.realityforge.webtack.model.tools.processors.remove_includes;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RemoveIncludes" )
public final class RemoveIncludesProcessorFactory
  implements ProcessorFactory
{
  public String interfacePattern;
  public String mixinPattern;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RemoveIncludesProcessor( extractPattern( "interfacePattern", interfacePattern ),
                                        extractPattern( "mixinPattern", mixinPattern ) );
  }

  @Nonnull
  private Pattern extractPattern( @Nonnull final String configKey, @Nullable final String input )
  {
    if ( null == input )
    {
      throw new IllegalArgumentException( "IncludeRemovalProcessor missing required " +
                                          configKey + " configuration value" );
    }
    return Pattern.compile( input );
  }
}
