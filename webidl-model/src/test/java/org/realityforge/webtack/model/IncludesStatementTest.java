package org.realityforge.webtack.model;

import java.io.IOException;
import java.util.Collections;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
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
    final WebIDLParser.IncludesStatementContext ctx = createParser( webIDL ).includesStatement();
    final IncludesStatement includesStatement =
      WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( includesStatement.getInterfaceName(), interfaceName );
    assertEquals( includesStatement.getMixinName(), mixinName );
  }
}
