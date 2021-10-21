package akasha.core;

import akasha.lang.JsIterable;

@SuppressWarnings( "unused" )
public final class JsWeakSetTestCompile
{
  static JsWeakSet<?> $typeReference$;

  public static <T> JsWeakSet<T> JsWeakSet()
  {
    return new JsWeakSet<>();
  }

  public static <T> JsWeakSet<T> JsWeakSet( final JsIterable<T> values )
  {
    return new JsWeakSet<>( values );
  }

  public static <T> JsWeakSet<T> JsWeakSet( final T[] values )
  {
    return new JsWeakSet<>( values );
  }

  public static <T> JsWeakSet<T> add( final JsWeakSet<T> $instance, final T value )
  {
    return $instance.add( value );
  }

  public static <T> boolean delete( final JsWeakSet<T> $instance, final T value )
  {
    return $instance.delete( value );
  }

  public static <T> boolean has( final JsWeakSet<T> $instance, final T value )
  {
    return $instance.has( value );
  }
}
