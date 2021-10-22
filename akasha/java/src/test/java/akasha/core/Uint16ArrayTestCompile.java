package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;

@SuppressWarnings( "unused" )
public final class Uint16ArrayTestCompile
{
  static Uint16Array $typeReference$;

  public static ArrayBuffer buffer( final Uint16Array type )
  {
    return type.buffer();
  }

  public static int byteLength( final Uint16Array type )
  {
    return type.byteLength();
  }

  public static int byteOffset( final Uint16Array type )
  {
    return type.byteOffset();
  }

  public static int length( final Uint16Array type )
  {
    return type.length();
  }

  public static Uint16Array of( final int[] element )
  {
    return Uint16Array.of( element );
  }

  public static Uint16Array copyWithin( final Uint16Array $instance, final int target,
                                        final int start, final int end )
  {
    return $instance.copyWithin( target, start, end );
  }

  public static Uint16Array copyWithin( final Uint16Array $instance, final int target,
                                        final int start )
  {
    return $instance.copyWithin( target, start );
  }

  public static void set( final Uint16Array $instance, final Uint16Array array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint16Array $instance, final Uint16Array array )
  {
    $instance.set( array );
  }

  public static void set( final Uint16Array $instance, final JsArray<Double> array,
                          final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint16Array $instance, final double[] array, final int offset )
  {
    $instance.set( array, offset );
  }

  public static void set( final Uint16Array $instance, final JsArray<Double> array )
  {
    $instance.set( array );
  }

  public static void set( final Uint16Array $instance, final double[] array )
  {
    $instance.set( array );
  }

  public static Uint16Array subarray( final Uint16Array $instance, final int start, final int end )
  {
    return $instance.subarray( start, end );
  }

  public static Uint16Array fill( final Uint16Array $instance, final int value, final int start,
                                  final int end )
  {
    return $instance.fill( value, start, end );
  }

  public static Uint16Array fill( final Uint16Array $instance, final int value, final int start )
  {
    return $instance.fill( value, start );
  }

  public static Uint16Array fill( final Uint16Array $instance, final int value )
  {
    return $instance.fill( value );
  }

  public static boolean includes( final Uint16Array $instance, final int searchElement,
                                  final int fromIndex )
  {
    return $instance.includes( searchElement, fromIndex );
  }

  public static boolean includes( final Uint16Array $instance, final int searchElement )
  {
    return $instance.includes( searchElement );
  }

  public static int indexOf( final Uint16Array $instance, final int searchElement,
                             final int fromIndex )
  {
    return $instance.indexOf( searchElement, fromIndex );
  }

  public static int indexOf( final Uint16Array $instance, final int searchElement )
  {
    return $instance.indexOf( searchElement );
  }

  public static int lastIndexOf( final Uint16Array $instance, final int searchElement,
                                 final int fromIndex )
  {
    return $instance.lastIndexOf( searchElement, fromIndex );
  }

  public static int lastIndexOf( final Uint16Array $instance, final int searchElement )
  {
    return $instance.lastIndexOf( searchElement );
  }

  public static String join( final Uint16Array $instance, final String separator )
  {
    return $instance.join( separator );
  }

  public static String join( final Uint16Array $instance )
  {
    return $instance.join();
  }

  public static String toString_( final Uint16Array $instance )
  {
    return $instance.toString_();
  }

  public static JsIterator<Double> keys( Uint16Array $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<Double> values( Uint16Array $instance )
  {
    return $instance.values();
  }

  public static JsIterator<Uint16Array.Entry> entries( Uint16Array $instance )
  {
    return $instance.entries();
  }

  public static void forEach( Uint16Array $instance, Uint16Array.ForEachCallback callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint16Array $instance, Uint16Array.ForEachCallback2 callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( Uint16Array $instance, Uint16Array.ForEachCallback3 callback )
  {
    $instance.forEach( callback );
  }
}
