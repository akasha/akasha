package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringTypeTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertParse( "ByteString", StringType.BYTE_STRING );
    assertParse( "DOMString", StringType.DOM_STRING );
    assertParse( "USVString", StringType.USV_STRING );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final StringType expected )
    throws IOException
  {
    final WebIDLParser parser = createParser( idl );
    final StringType actual = StringType.parse( parser.stringType() );
    assertEquals( actual, expected );
    assertEquals( actual.getName(), idl );
  }
}
