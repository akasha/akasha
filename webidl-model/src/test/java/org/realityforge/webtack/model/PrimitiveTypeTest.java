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
    assertPrimitiveParse( "boolean", PrimitiveType.BOOLEAN, false );
    assertPrimitiveParse( "byte", PrimitiveType.BYTE, false );
    assertPrimitiveParse( "octet", PrimitiveType.OCTET, false );
    assertPrimitiveParse( "float", PrimitiveType.FLOAT, false );
    assertPrimitiveParse( "double", PrimitiveType.DOUBLE, false );
    assertPrimitiveParse( "unrestricted float", PrimitiveType.UNRESTRICTED_FLOAT, false );
    assertPrimitiveParse( "unrestricted double", PrimitiveType.UNRESTRICTED_DOUBLE, false );
    assertPrimitiveParse( "short", PrimitiveType.SHORT, false );
    assertPrimitiveParse( "long", PrimitiveType.LONG, false );
    assertPrimitiveParse( "long long", PrimitiveType.LONG_LONG, false );
    assertPrimitiveParse( "unsigned short", PrimitiveType.UNSIGNED_SHORT, false );
    assertPrimitiveParse( "unsigned long", PrimitiveType.UNSIGNED_LONG, false );
    assertPrimitiveParse( "unsigned long long", PrimitiveType.UNSIGNED_LONG_LONG, false );

    assertPrimitiveParse( "boolean", PrimitiveType.NULLABLE_BOOLEAN, true );
    assertPrimitiveParse( "byte", PrimitiveType.NULLABLE_BYTE, true );
    assertPrimitiveParse( "octet", PrimitiveType.NULLABLE_OCTET, true );
    assertPrimitiveParse( "float", PrimitiveType.NULLABLE_FLOAT, true );
    assertPrimitiveParse( "double", PrimitiveType.NULLABLE_DOUBLE, true );
    assertPrimitiveParse( "unrestricted float", PrimitiveType.NULLABLE_UNRESTRICTED_FLOAT, true );
    assertPrimitiveParse( "unrestricted double", PrimitiveType.NULLABLE_UNRESTRICTED_DOUBLE, true );
    assertPrimitiveParse( "short", PrimitiveType.NULLABLE_SHORT, true );
    assertPrimitiveParse( "long", PrimitiveType.NULLABLE_LONG, true );
    assertPrimitiveParse( "long long", PrimitiveType.NULLABLE_LONG_LONG, true );
    assertPrimitiveParse( "unsigned short", PrimitiveType.NULLABLE_UNSIGNED_SHORT, true );
    assertPrimitiveParse( "unsigned long", PrimitiveType.NULLABLE_UNSIGNED_LONG, true );
    assertPrimitiveParse( "unsigned long long", PrimitiveType.NULLABLE_UNSIGNED_LONG_LONG, true );
  }

  private void assertPrimitiveParse( @Nonnull final String idl,
                                     @Nonnull final PrimitiveType expected,
                                     final boolean nullable )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for
    // optional "long" which generates a warning
    final WebIDLParser parser = createParser( idl + " someVar" );
    final PrimitiveType actual = PrimitiveType.parse( parser.primitiveType(),nullable );
    assertEquals( actual, expected );
    assertEquals( actual.getTypeName(), idl );
    assertEquals( actual.isNullable(), nullable );
  }
}
