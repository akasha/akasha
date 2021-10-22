package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Int32ArrayTestCompile
{
  static Int32Array $typeReference$;

  public static ArrayBuffer buffer( final Int32Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Int32Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Int32Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Int32Array type )
  {
    return type.length();
  }

  public static Int32Array of( final int[] element )
  {
    return Int32Array.of( element );
  }

  public static Int32Array copyWithin( final Int32Array $instance, final int target, final int start,
                                       final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Int32Array copyWithin( final Int32Array $instance, final int target,
                                       final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Int32Array $instance, final Int32Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int32Array $instance, final Int32Array array )
  {
    $instance.set( array );
  }

  public static void set( final Int32Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int32Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int32Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Int32Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Int32Array subarray( final Int32Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Int32Array fill( final Int32Array $instance, final int value, final int start,
                                 final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Int32Array fill( final Int32Array $instance, final int value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Int32Array fill( final Int32Array $instance, final int value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Int32Array $instance, final int searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Int32Array $instance, final int searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Int32Array $instance, final int searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Int32Array $instance, final int searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Int32Array $instance, final int searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Int32Array $instance, final int searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Int32Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Int32Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Int32Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Int32Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Int32Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Int32Array.Entry> entries( Int32Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Int32Array $instance, Int32Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int32Array $instance, Int32Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int32Array $instance, Int32Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
