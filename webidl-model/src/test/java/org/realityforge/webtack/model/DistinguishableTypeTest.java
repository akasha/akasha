package org.realityforge.webtack.model;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DistinguishableTypeTest
  extends AbstractTest
{
  @Test
  public void parse()
    throws Exception
  {
    // primitives
    assertParse( "boolean", Kind.Boolean, true );
    assertParse( "byte", Kind.Byte, true );
    assertParse( "octet", Kind.Octet, true );
    assertParse( "float", Kind.Float, true );
    assertParse( "double", Kind.Double, true );
    assertParse( "unrestricted float", Kind.UnrestrictedFloat, true );
    assertParse( "unrestricted double", Kind.UnrestrictedDouble, true );
    assertParse( "short", Kind.Short, true );
    assertParse( "long", Kind.Long, true );
    assertParse( "long long", Kind.LongLong, true );
    assertParse( "unsigned short", Kind.UnsignedShort, true );
    assertParse( "unsigned long", Kind.UnsignedLong, true );
    assertParse( "unsigned long long", Kind.UnsignedLongLong, true );

    // buffer types
    assertParse( "ArrayBuffer", Kind.ArrayBuffer, true );
    assertParse( "DataView", Kind.DataView, true );
    assertParse( "Int8Array", Kind.Int8Array, true );
    assertParse( "Int16Array", Kind.Int16Array, true );
    assertParse( "Int32Array", Kind.Int32Array, true );
    assertParse( "Uint8Array", Kind.Uint8Array, true );
    assertParse( "Uint16Array", Kind.Uint16Array, true );
    assertParse( "Uint32Array", Kind.Uint32Array, true );
    assertParse( "Uint8ClampedArray", Kind.Uint8ClampedArray, true );
    assertParse( "Float32Array", Kind.Float32Array, true );
    assertParse( "Float64Array", Kind.Float64Array, true );

    // strings
    assertParse( "DOMString", Kind.DOMString, true );
    assertParse( "ByteString", Kind.ByteString, true );
    assertParse( "USVString", Kind.USVString, true );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final Kind expected, final boolean nullable )
    throws IOException
  {
    {
      // Explicitly supply a variable otherwise we get at EOF looking for optional "long" which generates a warning
      final Type actual = parseType( idl + " someVar" );
      assertEquals( actual.getKind(), expected );
      assertFalse( actual.isNullable() );
    }
    if ( nullable )
    {
      final Type actual = parseType( idl + "? someVar" );
      assertEquals( actual.getKind(), expected );
      assertTrue( actual.isNullable() );
    }
  }

  private Type parseType( @Nonnull final String webIDL )
    throws IOException
  {
    return DistinguishableType.parse( createParser( webIDL ).singleType() );
  }
}
