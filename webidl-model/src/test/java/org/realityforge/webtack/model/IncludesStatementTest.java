package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
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
    final IncludesStatement actual =
      WebIDLModelParser.parse( ctx, Collections.emptyList(), parseStartPosition( ctx ) );
    assertEquals( actual.getInterfaceName(), interfaceName );
    assertEquals( actual.getMixinName(), mixinName );
    assertEquals( actual, actual );
    assertEquals( actual.hashCode(), actual.hashCode() );


    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeIncludesStatement( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final List<Definition> definitions = WebIDLModelParser.parse( createParser( emittedIDL ).definitions() );
    assertEquals( definitions.size(), 1 );
    assertTrue( definitions.get( 0 ) instanceof IncludesStatement );
    final IncludesStatement element = (IncludesStatement) definitions.get( 0 );
    assertEquals( element, element );
    assertEquals( element.hashCode(), element.hashCode() );

    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

  }
}
