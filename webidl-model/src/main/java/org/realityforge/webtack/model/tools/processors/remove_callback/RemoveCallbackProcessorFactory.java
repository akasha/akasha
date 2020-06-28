package org.realityforge.webtack.model.tools.processors.remove_callback;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RemoveCallback" )
public final class RemoveCallbackProcessorFactory
  implements ProcessorFactory
{
  public String namePattern;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RemoveCallbackProcessor( extractPattern( namePattern ) );
  }

  @Nonnull
  private Pattern extractPattern( @Nullable final String input )
  {
    if ( null == input )
    {
      throw new IllegalArgumentException( "RemoveCallbackProcessor missing required namePattern configuration value" );
    }
    return Pattern.compile( input );
  }
}
