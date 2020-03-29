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
    assertParse( "any", Kind.Any, false );
    assertParse( "object", Kind.Object, true );
    assertParse( "symbol", Kind.Symbol, true );

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

    // promises

    assertType( ensurePromiseType( "Promise<void>" ).getResolveType(), Kind.Void, false );
    assertType( ensurePromiseType( "Promise<short>" ).getResolveType(), Kind.Short, false );
    assertType( ensurePromiseType( "Promise<short?>" ).getResolveType(), Kind.Short, true );
    assertType( ensurePromiseType( "Promise<any>" ).getResolveType(), Kind.Any, false );
    assertType( ensurePromiseType( "Promise<DOMString>" ).getResolveType(), Kind.DOMString, false );
    assertType( ensurePromiseType( "Promise<VisibilityState>" ).getResolveType(), Kind.Enumeration, false );
    assertType( ensurePromiseType( "Promise<XRSessionInit?>" ).getResolveType(), Kind.Enumeration, true );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final Kind expected, final boolean supportsNullable )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for optional "long" which generates a warning
    final String suffix = " someVar";
    ensureType( idl + suffix, expected, false );
    if ( supportsNullable )
    {
      ensureType( idl + "?" + suffix, expected, true );
    }
  }

  @Nonnull
  private PromiseType ensurePromiseType( @Nonnull final String idl )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.Promise, false );
    assertTrue( type instanceof PromiseType );
    return (PromiseType) type;
  }

  @Nonnull
  private Type ensureType( @Nonnull final String webIDL, @Nonnull final Kind kind, final boolean isNullable )
    throws IOException
  {
    final Type actual = parseType( webIDL );
    assertType( actual, kind, isNullable );
    return actual;
  }

  private void assertType( @Nonnull final Type type, @Nonnull final Kind kind, final boolean isNullable )
  {
    assertEquals( type.getKind(), kind );
    assertEquals( type.isNullable(), isNullable );
  }

  private Type parseType( @Nonnull final String webIDL )
    throws IOException
  {
    return DistinguishableType.parse( createParser( webIDL ).type() );
  }
}
