package org.realityforge.webtack.model.tools.processors.remove_member;

import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.ProcessorFactory;

@Name( "RemoveMember" )
public final class RemoveMemberProcessorFactory
  implements ProcessorFactory
{
  public String elementNamePattern;
  public String memberNamePattern;
  public List<ElementType> types;

  @Nonnull
  @Override
  public Processor create()
  {
    return new RemoveMemberProcessor( extractPattern( "elementNamePattern", elementNamePattern ),
                                      extractPattern( "memberNamePattern", memberNamePattern ),
                                      types );
  }

  @Nonnull
  private Pattern extractPattern( @Nonnull final String key, @Nullable final String input )
  {
    if ( null == input )
    {
      throw new IllegalArgumentException( "RemoveMemberProcessor missing required " + key + " configuration value" );
    }
    return Pattern.compile( input );
  }
}
