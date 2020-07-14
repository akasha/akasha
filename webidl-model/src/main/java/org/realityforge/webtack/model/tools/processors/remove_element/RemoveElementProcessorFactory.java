package org.realityforge.webtack.model.tools.processors.remove_element;

import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RemoveElement" )
public final class RemoveElementProcessorFactory
  implements ProcessorFactory
{
  public String namePattern;
  public List<ElementType> types;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RemoveElementProcessor( extractPattern( namePattern ), types );
  }

  @Nonnull
  private Pattern extractPattern( @Nullable final String input )
  {
    if ( null == input )
    {
      throw new IllegalArgumentException( "RemoveElementProcessor missing required namePattern configuration value" );
    }
    return Pattern.compile( input );
  }
}
