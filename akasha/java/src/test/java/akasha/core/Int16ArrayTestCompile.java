package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Int16ArrayTestCompile
{
  static Int16Array $typeReference$;

  public static ArrayBuffer buffer( final Int16Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Int16Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Int16Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Int16Array type )
  {
    return type.length();
  }

  public static Int16Array of( final short[] element )
  {
    return Int16Array.of( element );
  }

  public static Int16Array copyWithin( final Int16Array $instance, final int target, final int start,
                                       final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Int16Array copyWithin( final Int16Array $instance, final int target,
                                       final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Int16Array $instance, final Int16Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int16Array $instance, final Int16Array array )
  {
    $instance.set( array );
  }

  public static void set( final Int16Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int16Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int16Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Int16Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Int16Array subarray( final Int16Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Int16Array fill( final Int16Array $instance, final short value, final int start,
                                 final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Int16Array fill( final Int16Array $instance, final short value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Int16Array fill( final Int16Array $instance, final short value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Int16Array $instance, final short searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Int16Array $instance, final short searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Int16Array $instance, final short searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Int16Array $instance, final short searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Int16Array $instance, final short searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Int16Array $instance, final short searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Int16Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Int16Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Int16Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Int16Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Int16Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Int16Array.Entry> entries( Int16Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Int16Array $instance, Int16Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int16Array $instance, Int16Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int16Array $instance, Int16Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
