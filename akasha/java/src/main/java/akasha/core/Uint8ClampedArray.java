package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;
import akasha.lang.JsIterator;
import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;

/**
 * The Uint8ClampedArray typed array represents an array of 8-bit unsigned integers clamped to 0-255; if you
 * specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer,
 * the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements
 * in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray">Uint8ClampedArray - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-typedarray-objects">TypedArray Objects - ECMA</a>
 * @see <a href="https://heycam.github.io/webidl/#idl-Uint8ClampedArray">Uint8ClampedArray - WebIDL</a>
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Uint8ClampedArray" )
public class Uint8ClampedArray
  extends JsObject
  implements IntegerTypedArray, JsIterable<Uint8ClampedArray.Entry>
{
  /**
   * The BYTES_PER_ELEMENT property represents the size in bytes of each element in an typed array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/BYTES_PER_ELEMENT">TypedArray.BYTES_PER_ELEMENT - MDN</a>
   */
  @JsOverlay
  public static final int BYTES_PER_ELEMENT = 1;
  /**
   * The name property represents a string value of the typed array constructor name.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/name">TypedArray.name - MDN</a>
   */
  @JsOverlay
  public static final String name = "Uint8ClampedArray";

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( final int length )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final Uint8ClampedArray array )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final JsArray<Double> array )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final double[] array )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final ArrayBuffer buffer, final int byteOffset,
                            final int length )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final ArrayBuffer buffer, final int byteOffset )
  {
  }

  /**
   * The Uint8ClampedArray() constructor creates a typed array of 8-bit unsigned integers clamped to 0-255; if you specified a value that is out of the range of [0,255], 0 or 255 will be set instead; if you specify a non-integer, the nearest integer will be set. The contents are initialized to 0. Once established, you can reference elements in the array using the object's methods, or using standard array index syntax (that is, using bracket notation).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Uint8ClampedArray/Uint8ClampedArray">Uint8ClampedArray.Uint8ClampedArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-typedarray-constructors">TypedArray constructors - ECMAScript (ECMA-262)</a>
   */
  public Uint8ClampedArray( @Nonnull final ArrayBuffer buffer )
  {
  }

  /**
   * The buffer accessor property represents the ArrayBuffer referenced by a TypedArray at construction time.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/buffer">TypedArray.buffer - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-get-%25typedarray%25.prototype.buffer">(ECMAScript) # sec-get-%typedarray%.prototype.buffer</a>
   */
  @JsProperty( name = "buffer" )
  @Nonnull
  public native ArrayBuffer buffer();

  /**
   * The byteLength accessor property represents the length (in bytes) of the typed array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/byteLength">TypedArray.byteLength - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-get-%25typedarray%25.prototype.bytelength">(ECMAScript) # sec-get-%typedarray%.prototype.bytelength</a>
   */
  @JsProperty( name = "byteLength" )
  public native int byteLength();

  /**
   * The byteOffset accessor property represents the offset (in bytes) of a typed array from the start of its ArrayBuffer.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/byteOffset">TypedArray.byteOffset - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-get-%25typedarray%25.prototype.byteoffset">(ECMAScript) # sec-get-%typedarray%.prototype.byteoffset</a>
   */
  @JsProperty( name = "byteOffset" )
  public native int byteOffset();

  /**
   * The length accessor property represents the length (in elements) of a typed array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/length">TypedArray.length - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-get-%25typedarray%25.prototype.length">(ECMAScript) # sec-get-%typedarray%.prototype.length</a>
   */
  @JsProperty( name = "length" )
  public native int length();

  /**
   * The TypedArray.of() method creates a new typed array from a variable number of arguments. This method is nearly the same as Array.of().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/of">TypedArray.of - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.of">(ECMAScript) # sec-%typedarray%.of</a>
   */
  @JsNonNull
  public static native Uint8ClampedArray of( short... element );

  /**
   * The copyWithin() method shallow copies part of an array to another location in the same array and returns it without modifying its length.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/copyWithin">TypedArray.prototype.copyWithin() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-%25typedarray%25.prototype.copywithin">%TypedArray%.prototype.copyWithin - ECMA</a>
   */
  @JsNonNull
  public native Uint8ClampedArray copyWithin( int target, int start, int end );

  /**
   * The copyWithin() method shallow copies part of an array to another location in the same array and returns it without modifying its length.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/copyWithin">TypedArray.prototype.copyWithin() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-%25typedarray%25.prototype.copywithin">%TypedArray%.prototype.copyWithin - ECMA</a>
   */
  @JsNonNull
  public native Uint8ClampedArray copyWithin( int target, int start );

  @JsOverlay
  public final short getAt( final int index )
  {
    return Js.<JsArrayLike<Any>>cast( this ).getAt( index ).asShort();
  }

  @JsOverlay
  public final void setAt( final int index, final short value )
  {
    Js.<JsArrayLike<Short>>cast( this ).setAt( index, value );
  }

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  public native void set( @Nonnull Uint8ClampedArray array, int offset );

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  public native void set( @Nonnull Uint8ClampedArray array );

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  public native void set( @Nonnull JsArray<Double> array, int offset );

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  public native void set( @Nonnull double[] array, int offset );

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  public native void set( @Nonnull JsArray<Double> array );

  /**
   * The set() method stores multiple values in the typed array, reading input values from a specified array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/set">TypedArray.set - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.set-array-offset">(ECMAScript) # sec-%typedarray%.prototype.set-array-offset</a>
   */
  @JsOverlay
  public final void set( @Nonnull final double... array )
  {
    _set( array );
  }

  @JsMethod( name = "set" )
  private native void _set( @Nonnull double[] array );

  /**
   * The subarray() method returns a new TypedArray on the same ArrayBuffer store and with the same element types as for this TypedArray object. The begin offset is inclusive and the end offset is exclusive. TypedArray is one of the typed array types.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/subarray">TypedArray.subarray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.subarray">(ECMAScript) # sec-%typedarray%.prototype.subarray</a>
   */
  @JsNonNull
  public native Uint8ClampedArray subarray( int start, int end );

  /**
   * The fill() method fills all the elements of a typed array from a start index to an end index with a static value. This method has the same algorithm as Array.prototype.fill(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/fill">TypedArray.fill - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.fill">(ECMAScript) # sec-%typedarray%.prototype.fill</a>
   */
  @JsNonNull
  public native Uint8ClampedArray fill( short value, int start, int end );

  /**
   * The fill() method fills all the elements of a typed array from a start index to an end index with a static value. This method has the same algorithm as Array.prototype.fill(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/fill">TypedArray.fill - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.fill">(ECMAScript) # sec-%typedarray%.prototype.fill</a>
   */
  @JsNonNull
  public native Uint8ClampedArray fill( short value, int start );

  /**
   * The fill() method fills all the elements of a typed array from a start index to an end index with a static value. This method has the same algorithm as Array.prototype.fill(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/fill">TypedArray.fill - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.fill">(ECMAScript) # sec-%typedarray%.prototype.fill</a>
   */
  @JsNonNull
  public native Uint8ClampedArray fill( short value );

  /**
   * The includes() method determines whether a typed array includes a certain element, returning true or false as appropriate. This method has the same algorithm as Array.prototype.includes(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/includes">TypedArray.includes - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.includes">(ECMAScript) # sec-%typedarray%.prototype.includes</a>
   */
  public native boolean includes( short searchElement, int fromIndex );

  /**
   * The includes() method determines whether a typed array includes a certain element, returning true or false as appropriate. This method has the same algorithm as Array.prototype.includes(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/includes">TypedArray.includes - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.includes">(ECMAScript) # sec-%typedarray%.prototype.includes</a>
   */
  public native boolean includes( short searchElement );

  /**
   * The indexOf() method returns the first index at which a given element can be found in the typed array, or -1 if it is not present. This method has the same algorithm as Array.prototype.indexOf(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/indexOf">TypedArray.indexOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.indexof">(ECMAScript) # sec-%typedarray%.prototype.indexof</a>
   */
  public native int indexOf( short searchElement, int fromIndex );

  /**
   * The indexOf() method returns the first index at which a given element can be found in the typed array, or -1 if it is not present. This method has the same algorithm as Array.prototype.indexOf(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/indexOf">TypedArray.indexOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.indexof">(ECMAScript) # sec-%typedarray%.prototype.indexof</a>
   */
  public native int indexOf( short searchElement );

  /**
   * The lastIndexOf() method returns the last index at which a given element can be found in the typed array, or -1 if it is not present. The typed array is searched backwards, starting at fromIndex. This method has the same algorithm as Array.prototype.lastIndexOf(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/lastIndexOf">TypedArray.lastIndexOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.lastindexof">(ECMAScript) # sec-%typedarray%.prototype.lastindexof</a>
   */
  public native int lastIndexOf( short searchElement, int fromIndex );

  /**
   * The lastIndexOf() method returns the last index at which a given element can be found in the typed array, or -1 if it is not present. The typed array is searched backwards, starting at fromIndex. This method has the same algorithm as Array.prototype.lastIndexOf(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/lastIndexOf">TypedArray.lastIndexOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.lastindexof">(ECMAScript) # sec-%typedarray%.prototype.lastindexof</a>
   */
  public native int lastIndexOf( short searchElement );

  /**
   * The join() method joins all elements of an array into a string. This method has the same algorithm as Array.prototype.join(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/join">TypedArray.join - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.join">(ECMAScript) # sec-%typedarray%.prototype.join</a>
   */
  @JsNonNull
  public native String join( @Nonnull String separator );

  /**
   * The join() method joins all elements of an array into a string. This method has the same algorithm as Array.prototype.join(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/join">TypedArray.join - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.join">(ECMAScript) # sec-%typedarray%.prototype.join</a>
   */
  @JsNonNull
  public native String join();

  /**
   * The toString() method returns a string representing the specified array and its elements. This method has the same algorithm as Array.prototype.toString(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/toString">TypedArray.toString - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.tostring">(ECMAScript) # sec-%typedarray%.prototype.tostring</a>
   */
  @JsMethod( name = "toString" )
  @JsNonNull
  public native String toString_();

  /**
   * The keys() method returns a new array iterator object that contains the keys for each index in the array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/keys">TypedArray.keys - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.keys">(ECMAScript) # sec-%typedarray%.prototype.keys</a>
   */
  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Double> keys();

  /**
   * The values() method returns a new array iterator object that contains the values for each index in the array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/values">TypedArray.values - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.values">(ECMAScript) # sec-%typedarray%.prototype.values</a>
   */
  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Double> values();

  /**
   * The entries() method returns a new Array iterator object that contains the key/value pairs for each index in the array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/entries">TypedArray.entries - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.entries">(ECMAScript) # sec-%typedarray%.prototype.entries</a>
   */
  @HasNoSideEffects
  @JsNonNull
  public native JsIterator<Entry> entries();

  /**
   * The forEach() method executes a provided function once per array element. This method has the same algorithm as Array.prototype.forEach(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/forEach">TypedArray.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.foreach">(ECMAScript) # sec-%typedarray%.prototype.foreach</a>
   */
  public native void forEach( @JsNonNull ForEachCallback callback );

  /**
   * The forEach() method executes a provided function once per array element. This method has the same algorithm as Array.prototype.forEach(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/forEach">TypedArray.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.foreach">(ECMAScript) # sec-%typedarray%.prototype.foreach</a>
   */
  public native void forEach( @JsNonNull ForEachCallback2 callback );

  /**
   * The forEach() method executes a provided function once per array element. This method has the same algorithm as Array.prototype.forEach(). TypedArray is one of the typed array types here.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray/forEach">TypedArray.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/multipage/indexed-collections.html#sec-%25typedarray%25.prototype.foreach">(ECMAScript) # sec-%typedarray%.prototype.foreach</a>
   */
  @JsOverlay
  public final void forEach( @Nonnull final ForEachCallback3 callback )
  {
    _forEach( Js.uncheckedCast( callback ) );
  }

  @JsMethod( name = "forEach" )
  private native void _forEach( @JsNonNull ClosureForEachCallback3 callback );

  @JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Array" )
  public static final class Entry
    extends JsArray<Object>
  {
    @JsOverlay
    public int index()
    {
      return getAtAsAny( 0 ).asInt();
    }

    @JsOverlay
    public short value()
    {
      return getAtAsAny( 1 ).asShort();
    }
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback
  {
    void item( short value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2
  {
    void item( short value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3
  {
    void item( short value, int index, @JsNonNull Uint8ClampedArray iterable );
  }

  @JsFunction
  @FunctionalInterface
  private interface ClosureForEachCallback3
  {
    void item( short value, int index, @JsNonNull TypedArray iterable );
  }
}
