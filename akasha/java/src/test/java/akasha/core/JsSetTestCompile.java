package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;
import akasha.lang.JsIteratorIterable;

@SuppressWarnings( "unused" )
public final class JsSetTestCompile
{
  static JsSet<?> $typeReference$;

  public static <T> JsSet<T> JsSet()
  {
    return new JsSet<>();
  }

  public static <T> JsSet<T> JsSet( final JsIterable<T> values )
  {
    return new JsSet<>( values );
  }

  public static <T> JsSet<T> JsSet( final T[] values )
  {
    return new JsSet<>( values );
  }

  public static <T> JsSet<T> add( final JsSet<T> $instance, final T value )
  {
    return $instance.add( value );
  }

  public static <T> int add( final JsSet<T> $instance )
  {
    return $instance.size();
  }

  public static <T> void clear( final JsSet<T> $instance )
  {
    $instance.clear();
  }

  public static <T> boolean delete( final JsSet<T> $instance, final T value )
  {
    return $instance.delete( value );
  }

  public static <T> boolean has( final JsSet<T> $instance, final T value )
  {
    return $instance.has( value );
  }

  public static <T> void forEach( final JsSet<T> $instance, final JsSet.ForEachCallback<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> void forEach( final JsSet<T> $instance, final JsSet.ForEachCallback2<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> void forEach( final JsSet<T> $instance, final JsSet.ForEachCallback3<T> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <T> JsIteratorIterable<JsArray<T>> entries( final JsSet<T> $instance )
  {
    return $instance.entries();
  }

  public static <T> JsIteratorIterable<T> keys( final JsSet<T> $instance )
  {
    return $instance.keys();
  }

  public static <T> JsIteratorIterable<T> values( final JsSet<T> $instance )
  {
    return $instance.values();
  }
}
