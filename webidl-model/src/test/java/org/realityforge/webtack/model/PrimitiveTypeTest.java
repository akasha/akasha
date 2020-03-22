package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PrimitiveTypeTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertPrimitiveParse( "boolean", PrimitiveType.BOOLEAN );
    assertPrimitiveParse( "byte", PrimitiveType.BYTE );
    assertPrimitiveParse( "octet", PrimitiveType.OCTET );
    assertPrimitiveParse( "float", PrimitiveType.FLOAT );
    assertPrimitiveParse( "double", PrimitiveType.DOUBLE );
    assertPrimitiveParse( "unrestricted float", PrimitiveType.UNRESTRICTED_FLOAT );
    assertPrimitiveParse( "unrestricted double", PrimitiveType.UNRESTRICTED_DOUBLE );
    assertPrimitiveParse( "short", PrimitiveType.SHORT );
    assertPrimitiveParse( "long", PrimitiveType.LONG );
    assertPrimitiveParse( "long long", PrimitiveType.LONG_LONG );
    assertPrimitiveParse( "unsigned short", PrimitiveType.UNSIGNED_SHORT );
    assertPrimitiveParse( "unsigned long", PrimitiveType.UNSIGNED_LONG );
    assertPrimitiveParse( "unsigned long long", PrimitiveType.UNSIGNED_LONG_LONG );
  }

  private void assertPrimitiveParse( @Nonnull final String idl, @Nonnull final PrimitiveType expected )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for
    // optional "long" which generates a warning
    final WebIDLParser parser = createParser( idl + " someVar" );
    final PrimitiveType actual = PrimitiveType.parse( parser.primitiveType() );
    assertEquals( actual, expected );
    assertEquals( actual.getName(), idl );
  }
}
