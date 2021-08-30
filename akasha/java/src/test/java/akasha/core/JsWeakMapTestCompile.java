package akasha.core;

import akasha.lang.JsIterable;

@SuppressWarnings( { "unchecked", "unused", "ConstantConditions" } )
public final class JsWeakMapTestCompile
{
  static JsWeakMap<?, ?> $typeReference$;

  public static <K, V> JsWeakMap<K, V> JsWeakMap()
  {
    return new JsWeakMap<>();
  }

  public static <K, V> JsWeakMap<K, V> JsWeakMap( final JsIterable<JsWeakMap.Entry<K, V>> pairs )
  {
    return new JsWeakMap<>( pairs );
  }

  public static <K, V> JsWeakMap<K, V> JsWeakMap( final JsWeakMap.Entry<K, V>... pairs )
  {
    return new JsWeakMap<>( pairs );
  }

  public static <K, V> V get( final JsWeakMap<K, V> $instance, final K key )
  {
    return $instance.get( key );
  }

  public static <K, V> JsWeakMap<K, V> set( final JsWeakMap<K, V> $instance, final K key, final V value )
  {
    return $instance.set( key, value );
  }

  public static <K, V> boolean delete( final JsWeakMap<K, V> $instance, final K key )
  {
    return $instance.delete( key );
  }

  public static <K, V> boolean has( final JsWeakMap<K, V> $instance, final K key )
  {
    return $instance.has( key );
  }

  public static <K, V> K key( final JsWeakMap.Entry<K, V> $instance )
  {
    return $instance.key();
  }

  public static <K, V> V value( final JsWeakMap.Entry<K, V> $instance )
  {
    return $instance.value();
  }
}
