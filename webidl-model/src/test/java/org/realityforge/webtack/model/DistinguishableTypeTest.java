package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DistinguishableTypeTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    assertParse( "boolean", Type.BOOLEAN, false );
    assertParse( "byte", Type.BYTE, false );
    assertParse( "octet", Type.OCTET, false );
    assertParse( "float", Type.FLOAT, false );
    assertParse( "double", Type.DOUBLE, false );
    assertParse( "unrestricted float", Type.UNRESTRICTED_FLOAT, false );
    assertParse( "unrestricted double", Type.UNRESTRICTED_DOUBLE, false );
    assertParse( "short", Type.SHORT, false );
    assertParse( "long", Type.LONG, false );
    assertParse( "long long", Type.LONG_LONG, false );
    assertParse( "unsigned short", Type.UNSIGNED_SHORT, false );
    assertParse( "unsigned long", Type.UNSIGNED_LONG, false );
    assertParse( "unsigned long long", Type.UNSIGNED_LONG_LONG, false );

    assertParse( "boolean", Type.NULLABLE_BOOLEAN, true );
    assertParse( "byte", Type.NULLABLE_BYTE, true );
    assertParse( "octet", Type.NULLABLE_OCTET, true );
    assertParse( "float", Type.NULLABLE_FLOAT, true );
    assertParse( "double", Type.NULLABLE_DOUBLE, true );
    assertParse( "unrestricted float", Type.NULLABLE_UNRESTRICTED_FLOAT, true );
    assertParse( "unrestricted double", Type.NULLABLE_UNRESTRICTED_DOUBLE, true );
    assertParse( "short", Type.NULLABLE_SHORT, true );
    assertParse( "long", Type.NULLABLE_LONG, true );
    assertParse( "long long", Type.NULLABLE_LONG_LONG, true );
    assertParse( "unsigned short", Type.NULLABLE_UNSIGNED_SHORT, true );
    assertParse( "unsigned long", Type.NULLABLE_UNSIGNED_LONG, true );
    assertParse( "unsigned long long", Type.NULLABLE_UNSIGNED_LONG_LONG, true );

    assertParse( "ArrayBuffer", Type.ARRAY_BUFFER, false );
    assertParse( "DataView", Type.DATA_VIEW, false );
    assertParse( "Int8Array", Type.INT8_ARRAY, false );
    assertParse( "Int16Array", Type.INT16_ARRAY, false );
    assertParse( "Int32Array", Type.INT32_ARRAY, false );
    assertParse( "Uint8Array", Type.UINT8_ARRAY, false );
    assertParse( "Uint16Array", Type.UINT16_ARRAY, false );
    assertParse( "Uint32Array", Type.UINT32_ARRAY, false );
    assertParse( "Uint8ClampedArray", Type.UINT8_CLAMPED_ARRAY, false );
    assertParse( "Float32Array", Type.FLOAT32_ARRAY, false );
    assertParse( "Float64Array", Type.FLOAT64_ARRAY, false );

    assertParse( "ArrayBuffer", Type.NULLABLE_ARRAY_BUFFER, true );
    assertParse( "DataView", Type.NULLABLE_DATA_VIEW, true );
    assertParse( "Int8Array", Type.NULLABLE_INT8_ARRAY, true );
    assertParse( "Int16Array", Type.NULLABLE_INT16_ARRAY, true );
    assertParse( "Int32Array", Type.NULLABLE_INT32_ARRAY, true );
    assertParse( "Uint8Array", Type.NULLABLE_UINT8_ARRAY, true );
    assertParse( "Uint16Array", Type.NULLABLE_UINT16_ARRAY, true );
    assertParse( "Uint32Array", Type.NULLABLE_UINT32_ARRAY, true );
    assertParse( "Uint8ClampedArray", Type.NULLABLE_UINT8_CLAMPED_ARRAY, true );
    assertParse( "Float32Array", Type.NULLABLE_FLOAT32_ARRAY, true );
    assertParse( "Float64Array", Type.NULLABLE_FLOAT64_ARRAY, true );

    assertParse( "ByteString", Type.BYTE_STRING, false );
    assertParse( "DOMString", Type.DOM_STRING, false );
    assertParse( "USVString", Type.USV_STRING, false );

    assertParse( "ByteString", Type.NULLABLE_BYTE_STRING, true );
    assertParse( "DOMString", Type.NULLABLE_DOM_STRING, true );
    assertParse( "USVString", Type.NULLABLE_USV_STRING, true );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final Type expected, final boolean nullable )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for
    // optional "long" which generates a warning
    final WebIDLParser parser = createParser( idl + ( nullable ? "?" : "" ) + " someVar" );
    final Type actual = DistinguishableType.parse( parser.singleType() );
    assertEquals( actual, expected );
    assertEquals( actual.getTypeName(), idl );
    assertEquals( actual.isNullable(), nullable );
  }
}
