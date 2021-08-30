package akasha.core;

import akasha.lang.JsIterable;
import akasha.lang.JsIteratorIterable;

@SuppressWarnings( { "unchecked", "unused", "ConstantConditions" } )
public final class JsMapTestCompile
{
  static JsMap<?, ?> $typeReference$;

  public static <K, V> JsMap<K, V> JsMap()
  {
    return new JsMap<>();
  }

  public static <K, V> JsMap<K, V> JsMap( final JsIterable<JsMap.Entry<K, V>> pairs )
  {
    return new JsMap<>( pairs );
  }

  public static <K, V> JsMap<K, V> JsMap( final JsMap.Entry<K, V>... pairs )
  {
    return new JsMap<>( pairs );
  }

  public static <K, V> V get( final JsMap<K, V> $instance, final K key )
  {
    return $instance.get( key );
  }

  public static <K, V> JsMap<K, V> set( final JsMap<K, V> $instance, final K key, final V value )
  {
    return $instance.set( key, value );
  }

  public static <K, V> int add( final JsMap<K, V> $instance )
  {
    return $instance.size();
  }

  public static <K, V> void clear( final JsMap<K, V> $instance )
  {
    $instance.clear();
  }

  public static <K, V> boolean delete( final JsMap<K, V> $instance, final K key )
  {
    return $instance.delete( key );
  }

  public static <K, V> boolean has( final JsMap<K, V> $instance, final K key )
  {
    return $instance.has( key );
  }

  public static <K, V> K key( final JsMap.Entry<K, V> $instance )
  {
    return $instance.key();
  }

  public static <K, V> V value( final JsMap.Entry<K, V> $instance )
  {
    return $instance.value();
  }

  public static <K, V> void forEach( final JsMap<K, V> $instance, final JsMap.ForEachCallback<V> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <K, V> void forEach( final JsMap<K, V> $instance, final JsMap.ForEachCallback2<K, V> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <K, V> void forEach( final JsMap<K, V> $instance, final JsMap.ForEachCallback3<K, V> forEachCallback )
  {
    $instance.forEach( forEachCallback );
  }

  public static <K, V> JsIteratorIterable<JsMap.Entry<K, V>> entries( final JsMap<K, V> $instance )
  {
    return $instance.entries();
  }

  public static <K, V> JsIteratorIterable<K> keys( final JsMap<K, V> $instance )
  {
    return $instance.keys();
  }

  public static <K, V> JsIteratorIterable<V> values( final JsMap<K, V> $instance )
  {
    return $instance.values();
  }
}
