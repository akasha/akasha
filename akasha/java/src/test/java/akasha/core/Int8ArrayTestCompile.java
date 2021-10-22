package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Int8ArrayTestCompile
{
  static Int8Array $typeReference$;

  public static ArrayBuffer buffer( final Int8Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Int8Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Int8Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Int8Array type )
  {
    return type.length();
  }

  public static Int8Array of( final byte[] element )
  {
    return Int8Array.of( element );
  }

  public static Int8Array copyWithin( final Int8Array $instance, final int target, final int start,
                                      final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Int8Array copyWithin( final Int8Array $instance, final int target, final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Int8Array $instance, final Int8Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int8Array $instance, final Int8Array array )
  {
    $instance.set( array );
  }

  public static void set( final Int8Array $instance, final JsArray<Double> array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int8Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Int8Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Int8Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Int8Array subarray( final Int8Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Int8Array fill( final Int8Array $instance, final byte value, final int start,
                                final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Int8Array fill( final Int8Array $instance, final byte value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Int8Array fill( final Int8Array $instance, final byte value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Int8Array $instance, final byte searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Int8Array $instance, final byte searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Int8Array $instance, final byte searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Int8Array $instance, final byte searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Int8Array $instance, final byte searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Int8Array $instance, final byte searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Int8Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Int8Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Int8Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Int8Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Int8Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Int8Array.Entry> entries( Int8Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Int8Array $instance, Int8Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int8Array $instance, Int8Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Int8Array $instance, Int8Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
