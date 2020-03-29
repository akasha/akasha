package org.realityforge.webtack.model;

import javax.annotation.Nullable;

public enum Kind
{
  /**
   * The any type is the union of all other possible non-union types.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-any">Any</a>
   */
  Any,
  /**
   * The void type has a unique value.
   * It can only be used as the return type of an operation or the parameter of a promise type.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-void">Void</a>
   */
  Void,
  /**
   * The boolean type has two values: true and false.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-boolean">Boolean</a>
   */
  Boolean,
  /**
   * The byte type is a signed integer type that has values in the range [−128, 127].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-byte">Byte</a>
   */
  Byte,
  /**
   * The octet type is an unsigned integer type that has values in the range [0, 255].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-octet">Octet</a>
   */
  Octet,
  /**
   * The short type is a signed integer type that has values in the range [−32768, 32767].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-short">Short</a>
   */
  Short,
  /**
   * The unsigned short type is an unsigned integer type that has values in the range [0, 65535].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-short">UnsignedShort</a>
   */
  UnsignedShort,
  /**
   * The long type is a signed integer type that has values in the range [−2147483648, 2147483647].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long">Long</a>
   */
  Long,
  /**
   * The unsigned long type is an unsigned integer type that has values in the range [0, 4294967295].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long">UnsignedLong</a>
   */
  UnsignedLong,
  /**
   * The long long type is a signed integer type that has values in the range [−9223372036854775808, 9223372036854775807].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long-long">LongLong</a>
   */
  LongLong,
  /**
   * The unsigned long long type is an unsigned integer type that has values in the range [0, 18446744073709551615].
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unsigned-long-long">UnsignedLongLong</a>
   */
  UnsignedLongLong,
  /**
   * The float type is a floating point numeric type that corresponds to the set of finite single-precision 32 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-float">Float</a>
   */
  Float,
  /**
   * The float type is a floating point numeric type that corresponds to the set of finite single-precision 32 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unrestricted-float">UnrestrictedFloat</a>
   */
  UnrestrictedFloat,
  /**
   * The double type is a floating point numeric type that corresponds to the set of finite double-precision 64 bit IEEE 754 floating point numbers. [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-double">Double</a>
   */
  Double,
  /**
   * The unrestricted double type is a floating point numeric type that corresponds to the set of all possible double-precision 64 bit IEEE 754 floating point numbers, finite, non-finite, and special "not a number" values (NaNs). [IEEE-754]
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-unrestricted-double">UnrestrictedDouble</a>
   */
  UnrestrictedDouble,
  /**
   * The DOMString type corresponds to the set of all possible sequences of code units.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-DOMString">DOMString</a>
   */
  DOMString( "String" ),
  /**
   * The ByteString type corresponds to the set of all possible sequences of bytes.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-ByteString">ByteString</a>
   */
  ByteString,
  /**
   * The USVString type corresponds to the set of all possible sequences of Unicode scalar values, which are all of the Unicode code points apart from the surrogate code points.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-USVString">USVString</a>
   */
  USVString,
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
   * An identifier that identifies an interface is used to refer to a type that corresponds to the set of all possible non-null references to objects that implement that interface.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-interface">Interface types</a>
   */
  Interface( null ),
  /**
   * An identifier that identifies a callback interface is used to refer to a type that corresponds to the set of all possible non-null references to objects.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-callback-interface">Callback interface types</a>
   */
  CallbackInterface( null ),
  /**
   * An identifier that identifies a dictionary is used to refer to a type that corresponds to the set of all dictionaries that adhere to the dictionary definition.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-dictionary">Dictionary types</a>
   */
  Dictionary( null ),
  /**
   * An identifier that identifies an enumeration is used to refer to a type whose values are the set of strings (sequences of code units, as with DOMString) that are the enumeration’s values.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-enumeration">Enumeration types</a>
   */
  Enumeration( null ),
  /**
   * An identifier that identifies a callback function is used to refer to a type whose values are references to objects that are functions with the given signature.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-callback-function">Callback function types</a>
   */
  CallbackFunction( null ),
  /**
   * The sequence&lt;T&gt; type is a parameterized type whose values are (possibly zero-length) lists of values of type T.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-sequence">Sequence types — sequence&lt;T&gt;</a>
   */
  Sequence( null ),
  /**
   * A record type is a parameterized type whose values are ordered maps with keys that are instances of K and values that are instances of V. K must be one of DOMString, USVString, or ByteString.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-record">Record types — record&lt;K, V&gt;</a>
   */
  Record( null ),
  /**
   * A promise type is a parameterized type whose values are references to objects that “is used as a place holder for the eventual results of a deferred (and possibly asynchronous) computation result of an asynchronous operation”.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-promise">Promise types — Promise&lt;T&gt;</a>
   */
  Promise( null ),
  /**
   * A union type is a type whose set of values is the union of those in two or more other types.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-union">Union types</a>
   */
  Union( null ),
  /**
   * An object that holds a pointer (which may be null) to a buffer of a fixed number of bytes.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-ArrayBuffer">ArrayBuffer</a>
   */
  ArrayBuffer,
  /**
   * A view on to an ArrayBuffer that allows typed access to integers and floating point values stored at arbitrary offsets into the buffer.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-DataView">DataView</a>
   */
  DataView,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 8-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int8Array">Int8Array</a>
   */
  Int8Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 16-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int16Array">Int16Array</a>
   */
  Int16Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 32-bit signed integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Int32Array">Int32Array</a>
   */
  Int32Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 8-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint8Array">Uint8Array</a>
   */
  Uint8Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 16-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint16Array">Uint16Array</a>
   */
  Uint16Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of two’s complement 32-bit unsigned integers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint32Array">Uint32Array</a>
   */
  Uint32Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of unsigned 8 bit integers with clamped conversions.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Uint8ClampedArray">Uint8ClampedArray</a>
   */
  Uint8ClampedArray,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of IEEE 754 32-bit floating point numbers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Float32Array">Float32Array</a>
   */
  Float32Array,
  /**
   * A view on to an ArrayBuffer that exposes it as an array of IEEE 754 64-bit floating point numbers.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-Float64Array">Float64Array</a>
   */
  Float64Array,
  /**
   * A frozen array type is a parameterized type whose values are references to objects that hold a fixed length array of unmodifiable values.
   *
   * @see <a href="https://heycam.github.io/webidl/#idl-frozen-array">Frozen array types — FrozenArray&lt;T&gt;</a>
   */
  FrozenArray( null );
  @Nullable
  private final String _typeName;

  Kind()
  {
    _typeName = name();
  }

  Kind( @Nullable final String typeName )
  {
    _typeName = typeName;
  }
}
