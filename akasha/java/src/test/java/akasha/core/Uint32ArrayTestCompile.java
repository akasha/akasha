package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Uint32ArrayTestCompile
{
  static Uint32Array $typeReference$;

  public static ArrayBuffer buffer( final Uint32Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Uint32Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Uint32Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Uint32Array type )
  {
    return type.length();
  }

  public static Uint32Array of( final int[] element )
  {
    return Uint32Array.of( element );
  }

  public static Uint32Array copyWithin( final Uint32Array $instance, final int target,
                                        final int start, final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Uint32Array copyWithin( final Uint32Array $instance, final int target,
                                        final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Uint32Array $instance, final Uint32Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint32Array $instance, final Uint32Array array )
  {
    $instance.set( array );
  }

  public static void set( final Uint32Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint32Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint32Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Uint32Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Uint32Array subarray( final Uint32Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Uint32Array fill( final Uint32Array $instance, final int value, final int start,
                                  final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Uint32Array fill( final Uint32Array $instance, final int value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Uint32Array fill( final Uint32Array $instance, final int value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Uint32Array $instance, final int searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Uint32Array $instance, final int searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Uint32Array $instance, final int searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Uint32Array $instance, final int searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Uint32Array $instance, final int searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Uint32Array $instance, final int searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Uint32Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Uint32Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Uint32Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Uint32Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Uint32Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Uint32Array.Entry> entries( Uint32Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Uint32Array $instance, Uint32Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint32Array $instance, Uint32Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint32Array $instance, Uint32Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
