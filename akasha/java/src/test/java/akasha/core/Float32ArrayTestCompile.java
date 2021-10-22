package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Float32ArrayTestCompile
{
  static Float32Array $typeReference$;

  public static ArrayBuffer buffer( final Float32Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Float32Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Float32Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Float32Array type )
  {
    return type.length();
  }

  public static Float32Array of( final float[] element )
  {
    return Float32Array.of( element );
  }

  public static Float32Array copyWithin( final Float32Array $instance, final int target,
                                         final int start, final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Float32Array copyWithin( final Float32Array $instance, final int target,
                                         final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Float32Array $instance, final Float32Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Float32Array $instance, final Float32Array array )
  {
    $instance.set( array );
  }

  public static void set( final Float32Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Float32Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Float32Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Float32Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Float32Array subarray( final Float32Array $instance, final int start,
                                       final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Float32Array fill( final Float32Array $instance, final float value, final int start,
                                   final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Float32Array fill( final Float32Array $instance, final float value,
                                   final int start )
  {
    return $instance.fill( value, start );
  }

  public static Float32Array fill( final Float32Array $instance, final float value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Float32Array $instance, final float searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Float32Array $instance, final float searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Float32Array $instance, final float searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Float32Array $instance, final float searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Float32Array $instance, final float searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Float32Array $instance, final float searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Float32Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Float32Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Float32Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Float32Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Float32Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Float32Array.Entry> entries( Float32Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Float32Array $instance, Float32Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Float32Array $instance, Float32Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Float32Array $instance, Float32Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
