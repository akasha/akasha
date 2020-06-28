package org.realityforge.webtack.model.tools.processors.remove_dictionary;

import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RemoveDictionary" )
public final class RemoveDictionaryProcessorFactory
  implements ProcessorFactory
{
  public String namePattern;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RemoveDictionaryProcessor( extractPattern( namePattern ) );
  }

  @Nonnull
  private Pattern extractPattern( @Nullable final String input )
  {
    if ( null == input )
    {
      throw new IllegalArgumentException( "RemoveDictionaryProcessor missing required namePattern configuration value" );
    }
    return Pattern.compile( input );
  }
}
