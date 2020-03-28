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
    assertParse( "ByteString", StringType.BYTE_STRING, false );
    assertParse( "DOMString", StringType.DOM_STRING, false );
    assertParse( "USVString", StringType.USV_STRING, false );

    assertParse( "ByteString", StringType.NULLABLE_BYTE_STRING, true );
    assertParse( "DOMString", StringType.NULLABLE_DOM_STRING, true );
    assertParse( "USVString", StringType.NULLABLE_USV_STRING, true );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final StringType expected, final boolean nullable )
    throws IOException
  {
    final WebIDLParser parser = createParser( idl );
    final StringType actual = StringType.parse( parser.stringType(), nullable );
    assertEquals( actual, expected );
    assertEquals( actual.getTypeName(), idl );
    assertEquals( actual.isNullable(), nullable );
  }
}
