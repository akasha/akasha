package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class IncludesStatementTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws IOException
  {
    assertIncludesStatement( "Entry includes Observable;", "Entry", "Observable" );
    assertIncludesStatement( "Window includes WindowSessionStorage;", "Window", "WindowSessionStorage" );
  }

  private void assertIncludesStatement( @Nonnull final String webIDL,
                                        @Nonnull final String interfaceName,
                                        @Nonnull final String mixinName )
    throws IOException
  {
    final IncludesStatement includesStatement =
      WebIDLModelParser.parse( createParser( webIDL ).includesStatement(), Collections.emptyList() );
    assertEquals( includesStatement.getInterfaceName(), interfaceName );
    assertEquals( includesStatement.getMixinName(), mixinName );
  }
}
