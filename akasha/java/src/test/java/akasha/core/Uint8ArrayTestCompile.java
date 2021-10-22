package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Uint8ArrayTestCompile
{
  static Uint8Array $typeReference$;

  public static ArrayBuffer buffer( final Uint8Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Uint8Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Uint8Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Uint8Array type )
  {
    return type.length();
  }

  public static Uint8Array of( final short[] element )
  {
    return Uint8Array.of( element );
  }

  public static Uint8Array copyWithin( final Uint8Array $instance, final int target, final int start,
                                       final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Uint8Array copyWithin( final Uint8Array $instance, final int target,
                                       final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Uint8Array $instance, final Uint8Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint8Array $instance, final Uint8Array array )
  {
    $instance.set( array );
  }

  public static void set( final Uint8Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint8Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint8Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Uint8Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Uint8Array subarray( final Uint8Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Uint8Array fill( final Uint8Array $instance, final short value, final int start,
                                 final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Uint8Array fill( final Uint8Array $instance, final short value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Uint8Array fill( final Uint8Array $instance, final short value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Uint8Array $instance, final short searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Uint8Array $instance, final short searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Uint8Array $instance, final short searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Uint8Array $instance, final short searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Uint8Array $instance, final short searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Uint8Array $instance, final short searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Uint8Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Uint8Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Uint8Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Uint8Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Uint8Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Uint8Array.Entry> entries( Uint8Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Uint8Array $instance, Uint8Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint8Array $instance, Uint8Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint8Array $instance, Uint8Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
