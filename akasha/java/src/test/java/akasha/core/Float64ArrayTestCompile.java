package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Float64ArrayTestCompile {
  static Float64Array $typeReference$;

  public static ArrayBuffer buffer(final Float64Array type) {
    return type.buffer();
  }

  public static int byteLength(final Float64Array type) {
    return type.byteLength();
  }

  public static int byteOffset(final Float64Array type) {
    return type.byteOffset();
  }

  public static int length(final Float64Array type) {
    return type.length();
  }

  public static Float64Array of(final double[] element) {
    return Float64Array.of( element );
  }

  public static Float64Array copyWithin(final Float64Array $instance, final int target,
      final int start, final int end) {
    return $instance.copyWithin( target, start, end );
  }

  public static Float64Array copyWithin(final Float64Array $instance, final int target,
      final int start) {
    return $instance.copyWithin( target, start );
  }

  public static void set(final Float64Array $instance, final Float64Array array, final int offset) {
    $instance.set( array, offset );
  }

  public static void set(final Float64Array $instance, final Float64Array array) {
    $instance.set( array );
  }

  public static void set(final Float64Array $instance, final JsArray<Double> array,
      final int offset) {
    $instance.set( array, offset );
  }

  public static void set(final Float64Array $instance, final double[] array, final int offset) {
    $instance.set( array, offset );
  }

  public static void set(final Float64Array $instance, final JsArray<Double> array) {
    $instance.set( array );
  }

  public static void set(final Float64Array $instance, final double[] array) {
    $instance.set( array );
  }

  public static Float64Array subarray(final Float64Array $instance, final int start,
      final int end) {
    return $instance.subarray( start, end );
  }

  public static Float64Array fill(final Float64Array $instance, final double value, final int start,
      final int end) {
    return $instance.fill( value, start, end );
  }

  public static Float64Array fill(final Float64Array $instance, final double value,
      final int start) {
    return $instance.fill( value, start );
  }

  public static Float64Array fill(final Float64Array $instance, final double value) {
    return $instance.fill( value );
  }

  public static boolean includes(final Float64Array $instance, final double searchElement,
      final int fromIndex) {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes(final Float64Array $instance, final double searchElement) {
    return $instance.includes( searchElement );
  }

  public static int indexOf(final Float64Array $instance, final double searchElement,
      final int fromIndex) {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf(final Float64Array $instance, final double searchElement) {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf(final Float64Array $instance, final double searchElement,
      final int fromIndex) {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf(final Float64Array $instance, final double searchElement) {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join(final Float64Array $instance, final String separator) {
    return $instance.join( separator );
  }

  public static String join(final Float64Array $instance) {
    return $instance.join();
  }

  public static String toString_(final Float64Array $instance) {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys(Float64Array $instance) {
    return $instance.keys();
  }

  public static JsIterator<Double> values(Float64Array $instance) {
    return $instance.values();
  }

  public static JsIterator<Float64Array.Entry> entries(Float64Array $instance) {
    return $instance.entries();
  }

  public static void forEach(Float64Array $instance, Float64Array.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(Float64Array $instance, Float64Array.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(Float64Array $instance, Float64Array.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }
}
