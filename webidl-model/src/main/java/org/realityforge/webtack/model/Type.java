package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
{
  @Nonnull
  public static final Type ARRAY_BUFFER = new Type( "ArrayBuffer", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_ARRAY_BUFFER = new Type( "ArrayBuffer", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type DATA_VIEW = new Type( "DataView", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_DATA_VIEW = new Type( "DataView", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type INT8_ARRAY = new Type( "Int8Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_INT8_ARRAY = new Type( "Int8Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type INT16_ARRAY = new Type( "Int16Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_INT16_ARRAY = new Type( "Int16Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type INT32_ARRAY = new Type( "Int32Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_INT32_ARRAY = new Type( "Int32Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type UINT8_ARRAY = new Type( "Uint8Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_UINT8_ARRAY = new Type( "Uint8Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type UINT16_ARRAY = new Type( "Uint16Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_UINT16_ARRAY = new Type( "Uint16Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type UINT32_ARRAY = new Type( "Uint32Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_UINT32_ARRAY = new Type( "Uint32Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type UINT8_CLAMPED_ARRAY = new Type( "Uint8ClampedArray", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_UINT8_CLAMPED_ARRAY =
    new Type( "Uint8ClampedArray", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type FLOAT32_ARRAY = new Type( "Float32Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_FLOAT32_ARRAY = new Type( "Float32Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type FLOAT64_ARRAY = new Type( "Float64Array", Flags.BUFFER_RELATED );
  @Nonnull
  public static final Type NULLABLE_FLOAT64_ARRAY = new Type( "Float64Array", Flags.BUFFER_RELATED | Flags.NULLABLE );
  @Nonnull
  public static final Type BOOLEAN = new Type( "boolean", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_BOOLEAN = new Type( "boolean", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type BYTE = new Type( "byte", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_BYTE = new Type( "byte", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type OCTET = new Type( "octet", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_OCTET = new Type( "octet", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type FLOAT = new Type( "float", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_FLOAT = new Type( "float", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type DOUBLE = new Type( "double", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_DOUBLE = new Type( "double", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type UNRESTRICTED_FLOAT = new Type( "unrestricted float", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_UNRESTRICTED_FLOAT =
    new Type( "unrestricted float", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type UNRESTRICTED_DOUBLE = new Type( "unrestricted double", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_UNRESTRICTED_DOUBLE =
    new Type( "unrestricted double", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type SHORT = new Type( "short", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_SHORT = new Type( "short", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type LONG = new Type( "long", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_LONG = new Type( "long", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type LONG_LONG = new Type( "long long", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_LONG_LONG = new Type( "long long", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type UNSIGNED_SHORT = new Type( "unsigned short", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_UNSIGNED_SHORT = new Type( "unsigned short", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type UNSIGNED_LONG = new Type( "unsigned long", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_UNSIGNED_LONG = new Type( "unsigned long", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type UNSIGNED_LONG_LONG = new Type( "unsigned long long", Flags.PRIMITIVE );
  @Nonnull
  public static final Type NULLABLE_UNSIGNED_LONG_LONG =
    new Type( "unsigned long long", Flags.PRIMITIVE | Flags.NULLABLE );
  @Nonnull
  public static final Type SYMBOL = new Type( "symbol", Flags.SYMBOL );
  @Nonnull
  public static final Type NULLABLE_SYMBOL = new Type( "symbol", Flags.SYMBOL | Flags.NULLABLE );
  @Nonnull
  public static final Type BYTE_STRING = new Type( "ByteString", Flags.STRING );
  @Nonnull
  public static final Type NULLABLE_BYTE_STRING = new Type( "ByteString", Flags.STRING | Flags.NULLABLE );
  @Nonnull
  public static final Type DOM_STRING = new Type( "DOMString", Flags.STRING );
  @Nonnull
  public static final Type NULLABLE_DOM_STRING = new Type( "DOMString", Flags.STRING | Flags.NULLABLE );
  @Nonnull
  public static final Type USV_STRING = new Type( "USVString", Flags.STRING );
  @Nonnull
  public static final Type NULLABLE_USV_STRING = new Type( "USVString", Flags.STRING | Flags.NULLABLE );
  @Nonnull
  public static final Type OBJECT = new Type( "object", Flags.OBJECT );
  @Nonnull
  public static final Type NULLABLE_OBJECT = new Type( "object", Flags.OBJECT | Flags.NULLABLE );
  @Nonnull
  public static final Type ANY = new Type( "any", Flags.ANY );
  @Nonnull
  private final String _typeName;
  private final int _flags;

  Type( @Nonnull final String typeName, final int flags )
  {
    _typeName = Objects.requireNonNull( typeName );
    _flags = flags;
  }

  @Nonnull
  public String getTypeName()
  {
    return _typeName;
  }

  public boolean isNullable()
  {
    return ( _flags & Flags.NULLABLE ) == Flags.NULLABLE;
  }

  public int getKind()
  {
    return _flags & Flags.KIND_MASK;
  }

  public boolean isPrimitive()
  {
    return getKind() == Flags.PRIMITIVE;
  }

  public boolean isStringType()
  {
    return getKind() == Flags.STRING;
  }

  public boolean isBufferRelated()
  {
    return getKind() == Flags.BUFFER_RELATED;
  }

  public boolean isSymbol()
  {
    return getKind() == Flags.SYMBOL;
  }

  public boolean isObject()
  {
    return getKind() == Flags.OBJECT;
  }

  public boolean isAny()
  {
    return getKind() == Flags.ANY;
  }

  public boolean isEnumeration()
  {
    return getKind() == Flags.ENUMERATION;
  }

  public boolean isPromise()
  {
    return getKind() == Flags.PROMISE;
  }

  public boolean isSequence()
  {
    return getKind() == Flags.SEQUENCE;
  }

  public static final class Flags
  {
    private Flags()
    {
    }

    public static final int PRIMITIVE = 0x0001;
    public static final int STRING = 0x0010;
    public static final int BUFFER_RELATED = 0x0011;
    public static final int SYMBOL = 0x0100;
    public static final int OBJECT = 0x0101;
    public static final int ANY = 0x0110;
    public static final int ENUMERATION = 0x0111;
    public static final int PROMISE = 0x1000;
    public static final int SEQUENCE = 0x1001;
    private static final int KIND_MASK = 0x1111;
    public static final int NULLABLE = 1 << 5;
  }
}
