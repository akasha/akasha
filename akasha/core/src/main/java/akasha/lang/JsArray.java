package akasha.lang;

import javaemul.internal.ArrayStamper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;

/**
 * The JavaScript Array class is a global object that is used in the construction of arrays; which are high-level, list-like objects.
 *
 * @param <T> the type of the array elements.
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array">Array - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-array-objects">Array Objects - ECMA</a>
 */
@JsType( name = "Array", isNative = true, namespace = JsPackage.GLOBAL )
public class JsArray<T>
  implements JsIterable<T>, JsArrayLike<T>
{
  @JsType( isNative = true, name = "Array", namespace = JsPackage.GLOBAL )
  public static final class Entry<T>
    extends JsArray<Object>
  {
    @JsOverlay
    public int key()
    {
      return getAtAsAny( 0 ).asInt();
    }

    @JsOverlay
    public T value()
    {
      return getAtAsAny( 1 ).cast();
    }
  }

  /**
   * Cast the specified array to a JsArray instance.
   *
   * @param array the native "java" array.
   * @param <T>   the type of the array elements.
   * @return the JsArray instance.
   */
  @JsOverlay
  @Nonnull
  public static <T> JsArray<T> asJsArray( @Nonnull final T[] array )
  {
    return Js.uncheckedCast( array );
  }

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsArrayLike<T> arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsArrayLike<T> arrayLike );

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsIterable<T> arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull JsIterable<T> arrayLike );

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull T[] arrayLike,
                                               @Nonnull Converter<? super T, ? extends R> mapFn );

  /**
   * The Array.from() static method creates a new, shallow-copied Array instance from an array-like or iterable object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/from">Array.from - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.from">Array.from - ECMA</a>
   */
  @Nonnull
  public static native <T, R> JsArray<R> from( @Nonnull T[] arrayLike );

  /**
   * The Array.isArray() method determines whether the passed value is an Array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/isArray">Array.isArray - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.isarray">Array.isArray - ECMA</a>
   */
  public static native boolean isArray( @Nullable Object value );

  /**
   * The Array.of() method creates a new Array instance from a variable number of arguments, regardless of number or type of the arguments.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/of">Array.of - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.of">Array.of - ECMA</a>
   */
  @SafeVarargs
  @Nonnull
  public static native <T> JsArray<T> of( @Nonnull T... var_args );

  /**
   * The length property of an object which is an instance of type Array sets or returns the number of elements in that array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/length">Array.prototype.length - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-properties-of-array-instances-length">Array.prototype.length - ECMA</a>
   */
  public int length;

  /**
   * The Array() constructor is used to create Array objects.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/Array">Array() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array-constructor">Array Constructor - ECMA</a>
   */
  @SafeVarargs
  public JsArray( @Nonnull final T... items )
  {
  }

  /**
   * Convert this JsArray to a native "java" array.
   * The this value will be returned but the type of  this will be stamped with the associated java type.
   *
   * @param reference the "java" array that is the template type.
   * @return the array as a java type.
   */
  @JsOverlay
  public final T[] asArray( @Nonnull final T[] reference )
  {
    return ArrayStamper.stampJavaTypeInfo( this, reference );
  }

  /**
   * The concat() method is used to merge two or more arrays. This method does not change the existing arrays, but instead returns a new array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/concat">Array.prototype.concat() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.concat">Array.prototype.concat() - ECMA</a>
   */
  @SafeVarargs
  @Nonnull
  public final native JsArray<T> concat( @Nonnull T... items );

  /**
   * The copyWithin() method shallow copies part of an array to another location in the same array and returns it without modifying its length.
   *
   * @param target Zero-based index at which to copy the sequence to. If negative, target will be counted from the end. If target is at or greater than arr.length, nothing will be copied. If target is positioned after start, the copied sequence will be trimmed to fit arr.length.
   * @param start  Zero-based index at which to start copying elements from. If negative, start will be counted from the end. If start is omitted, copyWithin will copy from index 0.
   * @param end    Zero-based index at which to end copying elements from. copyWithin copies up to but not including end. If negative, end will be counted from the end.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/copyWithin">Array.prototype.copyWithin() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.copyeithin">Array.prototype.copyWithin() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> copyWithin( int target, int start, int end );

  /**
   * The copyWithin() method shallow copies part of an array to another location in the same array and returns it without modifying its length.
   *
   * @param target Zero-based index at which to copy the sequence to. If negative, target will be counted from the end. If target is at or greater than arr.length, nothing will be copied. If target is positioned after start, the copied sequence will be trimmed to fit arr.length.
   * @param start  Zero-based index at which to start copying elements from. If negative, start will be counted from the end. If start is omitted, copyWithin will copy from index 0.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/copyWithin">Array.prototype.copyWithin() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.copyeithin">Array.prototype.copyWithin() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> copyWithin( int target, int start );

  /**
   * The entries() method returns a new Array Iterator object that contains the key/value pairs for each index in the array.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/entries">Array.prototype.entries() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.entries">Array.prototype.entries() - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<JsArray<Entry<T>>> entries();

  /**
   * The every() method tests whether all elements in the array pass the test implemented by the provided function.
   *
   * @param predicate A function to test each element.
   * @return true if the predicate returns true for every array element, else false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/every">Array.prototype.every() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.every">Array.prototype.every() - ECMA</a>
   */
  public native boolean every( @Nonnull Predicate<T> predicate );

  /**
   * The every() method tests whether all elements in the array pass the test implemented by the provided function.
   *
   * @param predicate A function to test each element.
   * @return true if the predicate returns true for every array element, else false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/every">Array.prototype.every() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.every">Array.prototype.every() - ECMA</a>
   */
  public native boolean every( @Nonnull Predicate2<T> predicate );

  /**
   * The every() method tests whether all elements in the array pass the test implemented by the provided function.
   *
   * @param predicate A function to test each element.
   * @return true if the predicate returns true for every array element, else false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/every">Array.prototype.every() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.every">Array.prototype.every() - ECMA</a>
   */
  public native boolean every( @Nonnull Predicate3<T> predicate );

  /**
   * The fill() method changes all elements in an array to a static value, from a start index to an end index.
   *
   * @param value the value to fill the array with.
   * @param begin the start index.
   * @param end   the end index.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/fill">Array.prototype.fill() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.fill">Array.prototype.fill() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> fill( @Nullable T value, int begin, int end );

  /**
   * The fill() method changes all elements in an array to a static value, from a start index to the end of the array.
   *
   * @param value the value to fill the array with.
   * @param begin the start index.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/fill">Array.prototype.fill() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.fill">Array.prototype.fill() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> fill( @Nullable T value, int begin );

  /**
   * The fill() method changes all elements in an array to a static value.
   *
   * @param value the value to fill the array with.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/fill">Array.prototype.fill() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.fill">Array.prototype.fill() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> fill( @Nullable T value );

  /**
   * The filter() method creates a new array with all elements that pass the test implemented by the provided function.
   *
   * @param predicate the function used to test each element.
   * @return the new array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter">Array.prototype.filter() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.filter">Array.prototype.filter() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate<T> predicate );

  /**
   * The filter() method creates a new array with all elements that pass the test implemented by the provided function.
   *
   * @param predicate the function used to test each element.
   * @return the new array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter">Array.prototype.filter() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.filter">Array.prototype.filter() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate2<T> predicate );

  /**
   * The filter() method creates a new array with all elements that pass the test implemented by the provided function.
   *
   * @param predicate the function used to test each element.
   * @return the new array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter">Array.prototype.filter() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.filter">Array.prototype.filter() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> filter( @Nonnull Predicate3<T> predicate );

  /**
   * The find() method returns the value of the first element in the provided array that satisfies the provided testing function.
   *
   * @param predicate the function used to test each element.
   * @return the element if any.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/find">Array.prototype.find() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.find">Array.prototype.find() - ECMA</a>
   */
  @Nullable
  public native T find( @Nonnull Predicate<T> predicate );

  /**
   * The find() method returns the value of the first element in the provided array that satisfies the provided testing function.
   *
   * @param predicate the function used to test each element.
   * @return the element if any.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/find">Array.prototype.find() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.find">Array.prototype.find() - ECMA</a>
   */
  @Nullable
  public native T find( @Nonnull Predicate2<T> predicate );

  /**
   * The find() method returns the value of the first element in the provided array that satisfies the provided testing function.
   *
   * @param predicate the function used to test each element.
   * @return the element if any.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/find">Array.prototype.find() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.find">Array.prototype.find() - ECMA</a>
   */
  @Nullable
  public native T find( @Nonnull Predicate3<T> predicate );

  /**
   * The findIndex() method returns the index of the first element in the array that satisfies the provided testing function. Otherwise, it returns -1, indicating that no element passed the test.
   *
   * @param predicate the function used to test each element.
   * @return the index of the matched element or -1 if no such element found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/findIndex">Array.prototype.findIndex() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.findindex">Array.prototype.findIndex() - ECMA</a>
   */
  public native int findIndex( @Nonnull Predicate<T> predicate );

  /**
   * The findIndex() method returns the index of the first element in the array that satisfies the provided testing function. Otherwise, it returns -1, indicating that no element passed the test.
   *
   * @param predicate the function used to test each element.
   * @return the index of the matched element or -1 if no such element found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/findIndex">Array.prototype.findIndex() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.findindex">Array.prototype.findIndex() - ECMA</a>
   */
  public native int findIndex( @Nonnull Predicate2<T> predicate );

  /**
   * The findIndex() method returns the index of the first element in the array that satisfies the provided testing function. Otherwise, it returns -1, indicating that no element passed the test.
   *
   * @param predicate the function used to test each element.
   * @return the index of the matched element or -1 if no such element found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/findIndex">Array.prototype.findIndex() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.findindex">Array.prototype.findIndex() - ECMA</a>
   */
  public native int findIndex( @Nonnull Predicate3<T> predicate );

  /**
   * The flat() method creates a new array with all sub-array elements concatenated into it recursively up to the specified depth.
   *
   * @return a new array with the sub-array elements concatenated into it.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/flat">Array.prototype.flat() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.flat">Array.prototype.flat() - ECMA</a>
   */
  @Nonnull
  public native <S> JsArray<S> flat();

  /**
   * The flat() method creates a new array with all sub-array elements concatenated into it recursively up to the specified depth.
   *
   * @param depth the depth level specifying how deep a nested array structure should be flattened.
   * @return a new array with the sub-array elements concatenated into it.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/flat">Array.prototype.flat() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.flat">Array.prototype.flat() - ECMA</a>
   */
  @Nonnull
  public native <S> JsArray<S> flat( double depth );

  /**
   * The flatMap() method returns a new array formed by applying a given callback function to each element of the array, and then flattening the result by one level. It is identical to a map() followed by a flat() of depth 1, but slightly more efficient than calling those two methods separately.
   *
   * @param callback the function that produces an element of the new Array.
   * @return a new array with each element being the result of the callback function and flattened to a depth of 1.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/flatMap">Array.prototype.flatMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.flatmap">Array.prototype.flatMap() - ECMA</a>
   */
  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap<S, T> callback );

  /**
   * The flatMap() method returns a new array formed by applying a given callback function to each element of the array, and then flattening the result by one level. It is identical to a map() followed by a flat() of depth 1, but slightly more efficient than calling those two methods separately.
   *
   * @param callback the function that produces an element of the new Array.
   * @return a new array with each element being the result of the callback function and flattened to a depth of 1.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/flatMap">Array.prototype.flatMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.flatmap">Array.prototype.flatMap() - ECMA</a>
   */
  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap2<S, T> callback );

  /**
   * The flatMap() method returns a new array formed by applying a given callback function to each element of the array, and then flattening the result by one level. It is identical to a map() followed by a flat() of depth 1, but slightly more efficient than calling those two methods separately.
   *
   * @param callback the function that produces an element of the new Array.
   * @return a new array with each element being the result of the callback function and flattened to a depth of 1.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/flatMap">Array.prototype.flatMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.flatmap">Array.prototype.flatMap() - ECMA</a>
   */
  @Nonnull
  public native <S> JsArray<S> flatMap( @Nonnull FlatMap3<S, T> callback );

  /**
   * The forEach() method executes a provided function once for each array element.
   *
   * @param callback the function to execute for each element in the Array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach">Array.prototype.forEach() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.foreach">Array.prototype.forEach() - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback<T> callback );

  /**
   * The forEach() method executes a provided function once for each array element.
   *
   * @param callback the function to execute for each element in the Array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach">Array.prototype.forEach() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.foreach">Array.prototype.forEach() - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback2<T> callback );

  /**
   * The forEach() method executes a provided function once for each array element.
   *
   * @param callback the function to execute for each element in the Array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach">Array.prototype.forEach() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.foreach">Array.prototype.forEach() - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback3<T> callback );

  /**
   * The includes() method determines whether an array includes a certain value among its entries, returning true or false as appropriate.
   *
   * @param searchElement the value to search for.
   * @param fromIndex     the position in this array at which to begin searching for searchElement.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/includes">Array.prototype.includes() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.includes">Array.prototype.includes() - ECMA</a>
   */
  public native boolean includes( @Nullable T searchElement, int fromIndex );

  /**
   * The includes() method determines whether an array includes a certain value among its entries, returning true or false as appropriate.
   *
   * @param searchElement the value to search for.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/includes">Array.prototype.includes() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.includes">Array.prototype.includes() - ECMA</a>
   */
  public native boolean includes( @Nullable T searchElement );

  /**
   * The indexOf() method returns the first index at which a given element can be found in the array, or -1 if it is not present.
   *
   * @param searchElement the value to search for.
   * @param fromIndex     the position in this array at which to begin searching for searchElement.
   * @return the first index of the element in the array or -1 if not found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/indexOf">Array.prototype.indexOf() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.indexof">Array.prototype.indexOf() - ECMA</a>
   */
  public native int indexOf( @Nonnull T searchElement, int fromIndex );

  /**
   * The indexOf() method returns the first index at which a given element can be found in the array, or -1 if it is not present.
   *
   * @param searchElement the value to search for.
   * @return the first index of the element in the array or -1 if not found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/indexOf">Array.prototype.indexOf() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.indexof">Array.prototype.indexOf() - ECMA</a>
   */
  public native int indexOf( @Nonnull T searchElement );

  /**
   * The join() method creates and returns a new string by concatenating all of the elements in an array (or an array-like object), separated by the specified separator string. If the array has only one item, then that item will be returned without using the separator.
   *
   * @param separator specifies a string to separate each pair of adjacent elements of the array. If separator is an empty string, all elements are joined without any characters in between them.
   * @return a string with all array elements joined. If arr.length is 0, the empty string is returned
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join">Array.prototype.join() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.join">Array.prototype.join() - ECMA</a>
   */
  @Nonnull
  public native String join( @Nonnull String separator );

  /**
   * The join() method creates and returns a new string by concatenating all of the elements in an array (or an array-like object), separated by commas. If the array has only one item, then that item will be returned without using the separator.
   *
   * @return a string with all array elements joined. If arr.length is 0, the empty string is returned
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join">Array.prototype.join() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.join">Array.prototype.join() - ECMA</a>
   */
  @Nonnull
  public native String join();

  /**
   * The keys() method returns a new Array Iterator object that contains the keys for each index in the array.
   *
   * @return a new Array iterator object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/keys">Array.prototype.join() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.keys">Array.prototype.keys() - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<Double> keys();

  /**
   * The lastIndexOf() method returns the last index at which a given element can be found in the array, or -1 if it is not present. The array is searched backwards, starting at fromIndex.
   *
   * @param searchElement the value to search for.
   * @param fromIndex     the index at which to start searching backwards.
   * @return the last index of the element in the array counting backwards from fromIndex or -1 if not found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/lastIndexOf">Array.prototype.lastIndexOf() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.lastindexof">Array.prototype.lastIndexOf() - ECMA</a>
   */
  public native int lastIndexOf( @Nullable T searchElement, int fromIndex );

  /**
   * The lastIndexOf() method returns the last index at which a given element can be found in the array, or -1 if it is not present. The array is searched backwards.
   *
   * @param searchElement the value to search for.
   * @return the last index of the element in the array counting backwards or -1 if not found.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/lastIndexOf">Array.prototype.lastIndexOf() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.lastindexof">Array.prototype.lastIndexOf() - ECMA</a>
   */
  public native int lastIndexOf( @Nullable T searchElement );

  /**
   * The map() method creates a new array populated with the results of calling a provided function on every element in the calling array.
   *
   * @param callback the callback that is called for every element of this array. Each time callback executes, the returned value is added to the new array.
   * @return a new array with each element being the result of the callback function.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map">Array.prototype.map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.map">Array.prototype.map() - ECMA</a>
   */
  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map<? extends R, T> callback );

  /**
   * The map() method creates a new array populated with the results of calling a provided function on every element in the calling array.
   *
   * @param callback the callback that is called for every element of this array. Each time callback executes, the returned value is added to the new array.
   * @return a new array with each element being the result of the callback function.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map">Array.prototype.map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.map">Array.prototype.map() - ECMA</a>
   */
  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map2<? extends R, T> callback );

  /**
   * The map() method creates a new array populated with the results of calling a provided function on every element in the calling array.
   *
   * @param callback the callback that is called for every element of this array. Each time callback executes, the returned value is added to the new array.
   * @return a new array with each element being the result of the callback function.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map">Array.prototype.map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.map">Array.prototype.map() - ECMA</a>
   */
  @Nonnull
  public native <R> JsArray<R> map( @Nonnull Map3<? extends R, T> callback );

  /**
   * The pop() method removes the last element from an array and returns that element. This method changes the length of the array.
   *
   * @return the element removed from the array or null if the array is empty.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/pop">Array.prototype.pop() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.pop">Array.prototype.pop() - ECMA</a>
   */
  public native T pop();

  /**
   * The push() method adds one or more elements to the end of an array and returns the new length of the array.
   *
   * @param elements the elements to add to the end of the array.
   * @return the new length of the array
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/push">Array.prototype.push() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.push">Array.prototype.push() - ECMA</a>
   */
  @SafeVarargs
  public final native int push( @Nonnull T... elements );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce<? extends R, T> reducer, R initialValue );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce2<? extends R, T> reducer, R initialValue );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce3<? extends R, T> reducer, R initialValue );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array except for the first.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce<? extends R, T> reducer );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array except for the first.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce2<? extends R, T> reducer );

  /**
   * The reduce() method executes a reducer function (that you provide) on each element of the array, resulting in single output value.
   *
   * @param reducer a function to execute on each element in the array except for the first.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduce">Array.prototype.reduce() - ECMA</a>
   */
  public native <R> R reduce( @Nonnull Reduce3<? extends R, T> reducer );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce<? extends R, T> reducer, R initialValue );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce2<? extends R, T> reducer, R initialValue );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce3<? extends R, T> reducer, R initialValue );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array except for the last.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce<? extends R, T> reducer );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array except for the last.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce2<? extends R, T> reducer );

  /**
   * The reduceRight() method applies a function against an accumulator and each value of the array (from right-to-left) to reduce it to a single value.
   *
   * @param reducer a function to execute on each element in the array except for the last.
   * @return the result value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduceRight">Array.prototype.reduceRight() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reduceright">Array.prototype.reduceRight() - ECMA</a>
   */
  public native <R> R reduceRight( @Nonnull Reduce3<? extends R, T> reducer );

  /**
   * The reverse() method reverses an array in place. The first array element becomes the last, and the last array element becomes the first.
   *
   * @return the reversed array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reverse">Array.prototype.reverse() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.reverse">Array.prototype.reverse() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> reverse();

  /**
   * The shift() method removes the first element from an array and returns that removed element. This method changes the length of the array.
   *
   * @return the element removed from the array or null if the array is empty.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/shift">Array.prototype.shift() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.shift">Array.prototype.shift() - ECMA</a>
   */
  public native T shift();

  /**
   * The slice() method returns a shallow copy of a portion of an array into a new array object selected from start to end (end not included) where start and end represent the index of items in that array. The original array will not be modified.
   *
   * @param begin the zero-based index at which to start extraction. A negative index can be used, indicating an offset from the end of the sequence. slice(-2) extracts the last two elements in the sequence.
   * @param end   the zero-based index before which to end extraction. slice extracts up to but not including end. For example, slice(1,4) extracts the second element through the fourth element (elements indexed 1, 2, and 3). A negative index can be used, indicating an offset from the end of the sequence. slice(2,-1) extracts the third element through the second-to-last element in the sequence.
   * @return a new array containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice">Array.prototype.slice() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.slice">Array.prototype.slice() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> slice( int begin, int end );

  /**
   * The slice() method returns a shallow copy of a portion of an array into a new array object selected from start to end (end not included) where start and end represent the index of items in that array. The original array will not be modified.
   *
   * @param begin the zero-based index at which to start extraction. A negative index can be used, indicating an offset from the end of the sequence. slice(-2) extracts the last two elements in the sequence.
   * @return a new array containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice">Array.prototype.slice() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.slice">Array.prototype.slice() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> slice( int begin );

  /**
   * The slice() method returns a shallow copy of the array. The original array will not be modified.
   *
   * @return a new array containing the extracted elements.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice">Array.prototype.slice() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.slice">Array.prototype.slice() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> slice();

  /**
   * The some() method tests whether at least one element in the array passes the test implemented by the provided function. It returns true if, in the array, it finds an element for which the provided function returns true; otherwise it returns false. It doesn't modify the array.
   *
   * @param predicate a predicate to test each element.
   * @return true if the predicate returns true for at least one element in the array, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/some">Array.prototype.some() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.some">Array.prototype.some() - ECMA</a>
   */
  public native boolean some( @Nonnull Predicate<T> predicate );

  /**
   * The some() method tests whether at least one element in the array passes the test implemented by the provided function. It returns true if, in the array, it finds an element for which the provided function returns true; otherwise it returns false. It doesn't modify the array.
   *
   * @param predicate a predicate to test each element.
   * @return true if the predicate returns true for at least one element in the array, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/some">Array.prototype.some() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.some">Array.prototype.some() - ECMA</a>
   */
  public native boolean some( @Nonnull Predicate2<T> predicate );

  /**
   * The some() method tests whether at least one element in the array passes the test implemented by the provided function. It returns true if, in the array, it finds an element for which the provided function returns true; otherwise it returns false. It doesn't modify the array.
   *
   * @param predicate a predicate to test each element.
   * @return true if the predicate returns true for at least one element in the array, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/some">Array.prototype.some() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.some">Array.prototype.some() - ECMA</a>
   */
  public native boolean some( @Nonnull Predicate3<T> predicate );

  /**
   * The sort() method sorts the elements of an array in place and returns the sorted array.
   *
   * @param compareFunction the function that defines the sort order.
   * @return the sorted array. Note that the array is sorted in place, and no copy is made.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort">Array.prototype.sort() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.sort">Array.prototype.sort() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> sort( @Nonnull Comparator<? super T> compareFunction );

  /**
   * The sort() method sorts the elements of an array in place and returns the sorted array. The sort order is ascending, built upon converting the elements into strings, then comparing their sequences of UTF-16 code units values.
   *
   * @return the sorted array. Note that the array is sorted in place, and no copy is made.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort">Array.prototype.sort() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.sort">Array.prototype.sort() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> sort();

  /**
   * The splice() method changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.
   *
   * @param start       The index at which to start changing the array. If greater than the length of the array, start will be set to the length of the array. In this case, no element will be deleted but the method will behave as an adding function, adding as many element as item[n*] provided. If negative, it will begin that many elements from the end of the array.
   * @param deleteCount An integer indicating the number of elements in the array to remove from start. If deleteCount is omitted, or if its value is equal to or larger than array.length - start (that is, if it is equal to or greater than the number of elements left in the array, starting at start), then all the elements from start to the end of the array will be deleted. If deleteCount is 0 or negative, no elements are removed. In this case, you should specify at least one new element
   * @param items       the elements to add to the array, beginning from start. If you do not specify any elements, splice() will only remove elements from the array.
   * @return An array containing the deleted elements. If only one element is removed, an array of one element is returned. If no elements are removed, an empty array is returned.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice">Array.prototype.splice() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.splice">Array.prototype.splice() - ECMA</a>
   */
  @SafeVarargs
  @Nonnull
  public final native JsArray<T> splice( int start, int deleteCount, @Nonnull T... items );

  /**
   * The splice() method changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.
   *
   * @param start The index at which to start changing the array. If greater than the length of the array, start will be set to the length of the array. In this case, no element will be deleted but the method will behave as an adding function, adding as many element as item[n*] provided. If negative, it will begin that many elements from the end of the array.
   * @return An array containing the deleted elements. If only one element is removed, an array of one element is returned. If no elements are removed, an empty array is returned.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice">Array.prototype.splice() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.splice">Array.prototype.splice() - ECMA</a>
   */
  @Nonnull
  public native JsArray<T> splice( int start );

  /**
   * The toString() method returns a string representing the specified array and its elements.
   *
   * @return a string representing the elements of the array.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/toString">Array.prototype.toString() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.tostring">Array.prototype.toString() - ECMA</a>
   */
  @JsMethod( name = "toString" )
  @Nonnull
  public native String toString_();

  /**
   * The unshift() method adds one or more elements to the beginning of an array and returns the new length of the array.
   *
   * @param elements the elements to add to the front of the array.
   * @return the new length property of the object upon which the method was called.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/unshift">Array.prototype.unshift() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.unshift">Array.prototype.unshift() - ECMA</a>
   */
  @SafeVarargs
  public final native int unshift( @Nonnull T... elements );

  /**
   * The values() method returns a new Array Iterator object that contains the values for each index in the array.
   *
   * @return a new Array iterator object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/values">Array.prototype.values() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-array.prototype.values">Array.prototype.values() - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<T> values();

  @JsFunction
  @FunctionalInterface
  public interface Comparator<T>
  {
    int compare( T item1, T item2 );
  }

  @JsFunction
  @FunctionalInterface
  public interface Converter<T, R>
  {
    R onInvoke( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<T>
  {
    void item( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<T>
  {
    void item( T value, int key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<T>
  {
    void item( T value, int key, @Nonnull JsArray<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate<T>
  {
    boolean test( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate2<T>
  {
    boolean test( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Predicate3<T>
  {
    boolean test( T value, int index, @Nonnull JsArray<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map<R, T>
  {
    R map( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map2<R, T>
  {
    R map( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Map3<R, T>
  {
    R map( T value, int index, @Nonnull JsArrayLike<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap2<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface FlatMap3<S, T>
  {
    @Nonnull
    JsArray<S> flatMap( T value, int index, @Nonnull JsArrayLike<T> array );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce<R, T>
  {
    R reduce( R accumulator, T currentValue );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce2<R, T>
  {
    R reduce( R accumulator, T currentValue, int index );
  }

  @JsFunction
  @FunctionalInterface
  public interface Reduce3<R, T>
  {
    R reduce( R accumulator, T currentValue, int index, @Nonnull JsArray<T> p3 );
  }
}
