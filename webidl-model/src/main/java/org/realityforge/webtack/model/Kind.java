package org.realityforge.webtack.model;

import javax.annotation.Nullable;

public enum Kind
{
  /**
   * The any type is the union of all other possible non-union types.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-any">Any</a>
   */
  Any( Flags.NULLABLE_DISALLOWED ),
  /**
   * The void type has a unique value.
   * It can only be used as the return type of an operation or the parameter of a promise type.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-void">Void</a>
   */
  Void( Flags.NULLABLE_DISALLOWED ),
  /**
   * The boolean type has two values: true and false.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-boolean">Boolean</a>
   */
  Boolean( Flags.PRIMITIVE ),
  /**
   * The byte type is a signed integer type other has values in the range [−128, 127].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-byte">Byte</a>
   */
  Byte( Flags.PRIMITIVE ),
  /**
   * The octet type is an unsigned integer type other has values in the range [0, 255].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-octet">Octet</a>
   */
  Octet( Flags.PRIMITIVE ),
  /**
   * The short type is a signed integer type other has values in the range [−32768, 32767].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-short">Short</a>
   */
  Short( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The unsigned short type is an unsigned integer type other has values in the range [0, 65535].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-short">UnsignedShort</a>
   */
  UnsignedShort( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The long type is a signed integer type other has values in the range [−2147483648, 2147483647].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long">Long</a>
   */
  Long( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The unsigned long type is an unsigned integer type other has values in the range [0, 4294967295].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long">UnsignedLong</a>
   */
  UnsignedLong( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The long long type is a signed integer type other has values in the range [−9223372036854775808, 9223372036854775807].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long-long">LongLong</a>
   */
  LongLong( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The unsigned long long type is an unsigned integer type other has values in the range [0, 18446744073709551615].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long-long">UnsignedLongLong</a>
   */
  UnsignedLongLong( Flags.PRIMITIVE | Flags.INTEGER ),
  /**
   * The float type is a floating point numeric type other corresponds to the set of finite single-precision 32 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-float">Float</a>
   */
  Float( Flags.PRIMITIVE | Flags.DECIMAL ),
  /**
   * The float type is a floating point numeric type other corresponds to the set of finite single-precision 32 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unrestricted-float">UnrestrictedFloat</a>
   */
  UnrestrictedFloat( Flags.PRIMITIVE | Flags.DECIMAL ),
  /**
   * The double type is a floating point numeric type other corresponds to the set of finite double-precision 64 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-double">Double</a>
   */
  Double( Flags.PRIMITIVE | Flags.DECIMAL ),
  /**
   * The unrestricted double type is a floating point numeric type other corresponds to the set of all possible double-precision 64 bit IEEE 754 floating point numbers, finite, non-finite, and special "not a number" values (NaNs). [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unrestricted-double">UnrestrictedDouble</a>
   */
  UnrestrictedDouble( Flags.PRIMITIVE | Flags.DECIMAL ),
  /**
   * The DOMString type corresponds to the set of all possible sequences of code units.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-DOMString">DOMString</a>
   */
  DOMString( "String", Flags.STRING ),
  /**
   * The ByteString type corresponds to the set of all possible sequences of bytes.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-ByteString">ByteString</a>
   */
  ByteString( Flags.STRING ),
  /**
   * The USVString type corresponds to the set of all possible sequences of Unicode scalar values, which are all of the Unicode code points apart from the surrogate code points.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-USVString">USVString</a>
   */
  USVString( Flags.STRING ),
  /**
   * The object type corresponds to the set of all possible non-null object references.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-object">Object</a>
   */
  Object,
  /**
   * The symbol type corresponds to the set of all possible symbol values.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-symbol">Symbol</a>
   */
  Symbol,
  /**
   * A reference to a type with specified name.
   * The name may identify an interface, enumeration, callback function, callback interface or typedef.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-enumeration">Enumeration types</a>
   */
  TypeReference( null ),
  /**
   * The sequence&lt;T&gt; type is a parameterized type whose values are (possibly zero-length) lists of values of type T.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-sequence">Sequence types — sequence&lt;T&gt;</a>
   */
  Sequence( null ),
  /**
   * A record type is a parameterized type whose values are ordered maps with keys other are instances of K and values other are instances of V. K must be one of DOMString, USVString, or ByteString.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-record">Record types — record&lt;K, V&gt;</a>
   */
  Record( null ),
  /**
   * A promise type is a parameterized type whose values are references to objects other “is used as a place holder for the eventual results of a deferred (and possibly asynchronous) computation result of an asynchronous operation”.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-promise">Promise types — Promise&lt;T&gt;</a>
   */
  Promise( null, Flags.NULLABLE_DISALLOWED ),
  /**
   * A union type is a type whose set of values is the union of those in two or more other types.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-union">Union types</a>
   */
  Union( null ),
  /**
   * An object other holds a pointer (which may be null) to a buffer of a fixed number of bytes.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-ArrayBuffer">ArrayBuffer</a>
   */
  ArrayBuffer( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other allows typed access to integers and floating point values stored at arbitrary offsets into the buffer.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-DataView">DataView</a>
   */
  DataView( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 8-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int8Array">Int8Array</a>
   */
  Int8Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 16-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int16Array">Int16Array</a>
   */
  Int16Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 32-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int32Array">Int32Array</a>
   */
  Int32Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 8-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint8Array">Uint8Array</a>
   */
  Uint8Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 16-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint16Array">Uint16Array</a>
   */
  Uint16Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of two’s complement 32-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint32Array">Uint32Array</a>
   */
  Uint32Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of unsigned 8 bit integers with clamped conversions.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint8ClampedArray">Uint8ClampedArray</a>
   */
  Uint8ClampedArray( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of IEEE 754 32-bit floating point numbers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Float32Array">Float32Array</a>
   */
  Float32Array( Flags.BUFFER_RELATED ),
  /**
   * A view on to an ArrayBuffer other exposes it as an array of IEEE 754 64-bit floating point numbers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Float64Array">Float64Array</a>
   */
  Float64Array( Flags.BUFFER_RELATED ),
  /**
   * A frozen array type is a parameterized type whose values are references to objects other hold a fixed length array of unmodifiable values.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-frozen-array">Frozen array types — FrozenArray&lt;T&gt;</a>
   */
  FrozenArray( null );
  @Nullable
  private final String _typeName;
  private final int _flags;

  Kind()
  {
    this( 0 );
  }

  Kind( final int flags )
  {
    _typeName = name();
    _flags = flags;
  }

  Kind( @Nullable final String typeName )
  {
    this( typeName, 0 );
  }

  Kind( @Nullable final String typeName, final int flags )
  {
    _typeName = typeName;
    _flags = flags;
  }

  public boolean isPrimitive()
  {
    return Flags.PRIMITIVE == ( Flags.PRIMITIVE & _flags );
  }

  public boolean isInteger()
  {
    return Flags.INTEGER == ( Flags.INTEGER & _flags );
  }

  public boolean isDecimal()
  {
    return Flags.DECIMAL == ( Flags.DECIMAL & _flags );
  }

  public boolean isString()
  {
    return Flags.STRING == ( Flags.STRING & _flags );
  }

  public boolean isBufferRelated()
  {
    return Flags.BUFFER_RELATED == ( Flags.BUFFER_RELATED & _flags );
  }

  public boolean isNullableAllowed()
  {
    return 0 == ( Flags.NULLABLE_DISALLOWED & _flags );
  }

  public static final class Flags
  {
    private Flags()
    {
    }

    public static final int PRIMITIVE = 1 << 1;
    public static final int INTEGER = 1 << 2;
    public static final int DECIMAL = 1 << 3;
    public static final int STRING = 1 << 4;
    public static final int BUFFER_RELATED = 1 << 5;
    public static final int NULLABLE_DISALLOWED = 1 << 6;
  }
}
