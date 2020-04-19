package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.annotation.Nonnull;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class TypeTest
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
    assertType( ensurePromiseType( "Promise<VisibilityState>" ).getResolveType(), Kind.TypeReference, false );
    assertType( ensurePromiseType( "Promise<XRSessionInit?>" ).getResolveType(), Kind.TypeReference, true );

    // enumerations
    assertEquals( ensureEnumerationType( "VisibilityState", false ).getName(), "VisibilityState" );
    assertEquals( ensureEnumerationType( "XRSessionMode", false ).getName(), "XRSessionMode" );
    assertEquals( ensureEnumerationType( "XRSessionInit?", true ).getName(), "XRSessionInit" );

    // sequences
    assertType( ensureSequenceType( "sequence<short>", false ).getItemType(), Kind.Short, false );
    assertType( ensureSequenceType( "sequence<long long>", false ).getItemType(), Kind.LongLong, false );
    assertType( ensureSequenceType( "sequence<long long?>", false ).getItemType(), Kind.LongLong, true );
    assertType( ensureSequenceType( "sequence<XRSessionMode>?", true ).getItemType(), Kind.TypeReference, false );

    // FrozenArrays
    assertFrozenArrayType( "FrozenArray<long>?", true, Kind.Long, false );
    assertFrozenArrayType( "FrozenArray<long?>?", true, Kind.Long, true );
    assertFrozenArrayType( "FrozenArray<Promise<DOMString>>", false, Kind.Promise, false );

    // records
    assertRecordType( "record<DOMString,long>?", true, Kind.DOMString, Kind.Long );
    assertRecordType( "record<DOMString,sequence<short>>", false, Kind.DOMString, Kind.Sequence );
    assertRecordType( "record<USVString,Promise<void>>", false, Kind.USVString, Kind.Promise );

    // unions
    {
      final UnionType unionType = ensureUnionType( "(long or long long or sequence<long>)", false );
      final List<Type> memberTypes = unionType.getMemberTypes();
      assertEquals( memberTypes.size(), 3 );
      assertEquals( memberTypes.get( 0 ).getKind(), Kind.Long );
      assertEquals( memberTypes.get( 1 ).getKind(), Kind.LongLong );
      assertEquals( memberTypes.get( 2 ).getKind(), Kind.Sequence );
    }

    {
      final UnionType unionType = ensureUnionType( "(long or (long long or sequence<long>))", false );
      final List<Type> memberTypes = unionType.getMemberTypes();
      assertEquals( memberTypes.size(), 2 );
      assertEquals( memberTypes.get( 0 ).getKind(), Kind.Long );
      assertEquals( memberTypes.get( 1 ).getKind(), Kind.Union );
    }

    {
      final UnionType unionType = ensureUnionType( "(long? or XRSessionMode)", false );
      final List<Type> memberTypes = unionType.getMemberTypes();
      assertEquals( memberTypes.size(), 2 );
      assertEquals( memberTypes.get( 0 ).getKind(), Kind.Long );
      assertEquals( memberTypes.get( 1 ).getKind(), Kind.TypeReference );
    }

    {
      final UnionType unionType = ensureUnionType( "(DOMString or XRSessionMode)?", true );
      final List<Type> memberTypes = unionType.getMemberTypes();
      assertEquals( memberTypes.size(), 2 );
      assertEquals( memberTypes.get( 0 ).getKind(), Kind.DOMString );
      assertEquals( memberTypes.get( 1 ).getKind(), Kind.TypeReference );
    }
  }

  @Nonnull
  private UnionType ensureUnionType( @Nonnull final String idl, final boolean isNullable )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.Union, isNullable );
    assertTrue( type instanceof UnionType );
    return (UnionType) type;
  }

  private void assertRecordType( @Nonnull final String idl,
                                 final boolean isNullable,
                                 @Nonnull final Kind keyKind,
                                 @Nonnull final Kind valueKind )
    throws IOException
  {
    final RecordType recordType = ensureRecordType( idl, isNullable );
    assertType( recordType.getKeyType(), keyKind, false );
    assertType( recordType.getValueType(), valueKind, false );
  }

  private void assertFrozenArrayType( @Nonnull final String idl,
                                      final boolean isNullable,
                                      @Nonnull final Kind itemKind,
                                      final boolean isItemNullable )
    throws IOException
  {
    assertType( ensureFrozenArrayType( idl, isNullable ).getItemType(), itemKind, isItemNullable );
  }

  private void assertParse( @Nonnull final String idl, @Nonnull final Kind expected, final boolean supportsNullable )
    throws IOException
  {
    ensureType( idl, expected, false );
    if ( supportsNullable )
    {
      ensureType( idl + "?", expected, true );
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
  private SequenceType ensureSequenceType( @Nonnull final String idl, final boolean isNullable )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.Sequence, isNullable );
    assertTrue( type instanceof SequenceType );
    return (SequenceType) type;
  }

  @Nonnull
  private FrozenArrayType ensureFrozenArrayType( @Nonnull final String idl, final boolean isNullable )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.FrozenArray, isNullable );
    assertTrue( type instanceof FrozenArrayType );
    return (FrozenArrayType) type;
  }

  @Nonnull
  private TypeReference ensureEnumerationType( @Nonnull final String idl, final boolean isNullable )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.TypeReference, isNullable );
    assertTrue( type instanceof TypeReference );
    return (TypeReference) type;
  }

  @Nonnull
  private RecordType ensureRecordType( @Nonnull final String idl, final boolean isNullable )
    throws IOException
  {
    final Type type = ensureType( idl, Kind.Record, isNullable );
    assertTrue( type instanceof RecordType );
    return (RecordType) type;
  }

  @Nonnull
  private Type ensureType( @Nonnull final String webIDL, @Nonnull final Kind kind, final boolean isNullable )
    throws IOException
  {
    // Explicitly supply a variable otherwise we get at EOF looking for optional "long" which generates a warning
    final Type actual = WebIDLModelParser.parse( createParser( webIDL + " someVar" ).type() );
    assertType( actual, kind, isNullable );

    final StringWriter writer = new StringWriter();
    WebIDLWriter.writeType( writer, actual );
    writer.close();
    final String emittedIDL = writer.toString();
    final Type element = WebIDLModelParser.parse( createParser( emittedIDL + " someVar" ).type() );
    assertEquals( element, actual );
    assertEquals( element.hashCode(), actual.hashCode() );
    assertTrue( element.equiv( actual ) );
    assertNotSame( element, actual );

    return actual;
  }

  private void assertType( @Nonnull final Type type, @Nonnull final Kind kind, final boolean isNullable )
  {
    assertEquals( type.getKind(), kind );
    assertEquals( type.isNullable(), isNullable );
  }
}
