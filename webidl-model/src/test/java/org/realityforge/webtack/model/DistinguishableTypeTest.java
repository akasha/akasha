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
    assertParse( "boolean", PrimitiveType.BOOLEAN, false );
    assertParse( "byte", PrimitiveType.BYTE, false );
    assertParse( "octet", PrimitiveType.OCTET, false );
    assertParse( "float", PrimitiveType.FLOAT, false );
    assertParse( "double", PrimitiveType.DOUBLE, false );
    assertParse( "unrestricted float", PrimitiveType.UNRESTRICTED_FLOAT, false );
    assertParse( "unrestricted double", PrimitiveType.UNRESTRICTED_DOUBLE, false );
    assertParse( "short", PrimitiveType.SHORT, false );
    assertParse( "long", PrimitiveType.LONG, false );
    assertParse( "long long", PrimitiveType.LONG_LONG, false );
    assertParse( "unsigned short", PrimitiveType.UNSIGNED_SHORT, false );
    assertParse( "unsigned long", PrimitiveType.UNSIGNED_LONG, false );
    assertParse( "unsigned long long", PrimitiveType.UNSIGNED_LONG_LONG, false );

    assertParse( "boolean", PrimitiveType.NULLABLE_BOOLEAN, true );
    assertParse( "byte", PrimitiveType.NULLABLE_BYTE, true );
    assertParse( "octet", PrimitiveType.NULLABLE_OCTET, true );
    assertParse( "float", PrimitiveType.NULLABLE_FLOAT, true );
    assertParse( "double", PrimitiveType.NULLABLE_DOUBLE, true );
    assertParse( "unrestricted float", PrimitiveType.NULLABLE_UNRESTRICTED_FLOAT, true );
    assertParse( "unrestricted double", PrimitiveType.NULLABLE_UNRESTRICTED_DOUBLE, true );
    assertParse( "short", PrimitiveType.NULLABLE_SHORT, true );
    assertParse( "long", PrimitiveType.NULLABLE_LONG, true );
    assertParse( "long long", PrimitiveType.NULLABLE_LONG_LONG, true );
    assertParse( "unsigned short", PrimitiveType.NULLABLE_UNSIGNED_SHORT, true );
    assertParse( "unsigned long", PrimitiveType.NULLABLE_UNSIGNED_LONG, true );
    assertParse( "unsigned long long", PrimitiveType.NULLABLE_UNSIGNED_LONG_LONG, true );

    assertParse( "ArrayBuffer", BufferRelatedType.ARRAY_BUFFER, false );
    assertParse( "DataView", BufferRelatedType.DATA_VIEW, false );
    assertParse( "Int8Array", BufferRelatedType.INT8_ARRAY, false );
    assertParse( "Int16Array", BufferRelatedType.INT16_ARRAY, false );
    assertParse( "Int32Array", BufferRelatedType.INT32_ARRAY, false );
    assertParse( "Uint8Array", BufferRelatedType.UINT8_ARRAY, false );
    assertParse( "Uint16Array", BufferRelatedType.UINT16_ARRAY, false );
    assertParse( "Uint32Array", BufferRelatedType.UINT32_ARRAY, false );
    assertParse( "Uint8ClampedArray", BufferRelatedType.UINT8_CLAMPED_ARRAY, false );
    assertParse( "Float32Array", BufferRelatedType.FLOAT32_ARRAY, false );
    assertParse( "Float64Array", BufferRelatedType.FLOAT64_ARRAY, false );

    assertParse( "ArrayBuffer", BufferRelatedType.NULLABLE_ARRAY_BUFFER, true );
    assertParse( "DataView", BufferRelatedType.NULLABLE_DATA_VIEW, true );
    assertParse( "Int8Array", BufferRelatedType.NULLABLE_INT8_ARRAY, true );
    assertParse( "Int16Array", BufferRelatedType.NULLABLE_INT16_ARRAY, true );
    assertParse( "Int32Array", BufferRelatedType.NULLABLE_INT32_ARRAY, true );
    assertParse( "Uint8Array", BufferRelatedType.NULLABLE_UINT8_ARRAY, true );
    assertParse( "Uint16Array", BufferRelatedType.NULLABLE_UINT16_ARRAY, true );
    assertParse( "Uint32Array", BufferRelatedType.NULLABLE_UINT32_ARRAY, true );
    assertParse( "Uint8ClampedArray", BufferRelatedType.NULLABLE_UINT8_CLAMPED_ARRAY, true );
    assertParse( "Float32Array", BufferRelatedType.NULLABLE_FLOAT32_ARRAY, true );
    assertParse( "Float64Array", BufferRelatedType.NULLABLE_FLOAT64_ARRAY, true );

    assertParse( "ByteString", StringType.BYTE_STRING, false );
    assertParse( "DOMString", StringType.DOM_STRING, false );
    assertParse( "USVString", StringType.USV_STRING, false );

    assertParse( "ByteString", StringType.NULLABLE_BYTE_STRING, true );
    assertParse( "DOMString", StringType.NULLABLE_DOM_STRING, true );
    assertParse( "USVString", StringType.NULLABLE_USV_STRING, true );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final Type expected, final boolean nullable )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for
    // optional "long" which generates a warning
    final WebIDLParser parser = createParser( idl + ( nullable ? "?" : "" ) + " someVar" );
    final Type actual = DistinguishableType.parse( parser.distinguishableType() );
    assertEquals( actual, expected );
    assertEquals( actual.getTypeName(), idl );
    assertEquals( actual.isNullable(), nullable );
  }
}
