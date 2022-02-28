package akasha.promise;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;

@SuppressWarnings( { "unchecked", "unused" } )
public final class PromiseTestCompile
{
  static Promise<?> $typeReference$;

  public static <V> Promise<JsArray<AllSettledResult<V>>> allSettled( final Promise<? extends V>... promises )
  {
    return Promise.allSettled( promises );
  }

  public static <V> Promise<JsArray<AllSettledResult<V>>> allSettled( final JsIterable<Promise<? extends V>> promises )
  {
    return Promise.allSettled( promises );
  }

  public static <V> Promise<JsArray<V>> all( final Promise<? extends V>... promises )
  {
    return Promise.all( promises );
  }

  public static <V> Promise<JsArray<V>> all( final JsIterable<Promise<? extends V>> promises )
  {
    return Promise.all( promises );
  }

  public static <V> Promise<V> any( final Promise<? extends V>... promises )
  {
    return Promise.any( promises );
  }

  public static <V> Promise<V> any( final JsIterable<Promise<? extends V>> promises )
  {
    return Promise.any( promises );
  }

  public static <V> Promise<V> race( final Promise<? extends V>... promises )
  {
    return Promise.race( promises );
  }

  public static <V> Promise<V> race( final JsIterable<Promise<? extends V>> promises )
  {
    return Promise.race( promises );
  }

  public static <V> Promise<V> resolve( final Promise<V> value )
  {
    return Promise.resolve( value );
  }

  public static <V> Promise<V> resolve( final V value )
  {
    return Promise.resolve( value );
  }

  public static <V> Promise<V> reject( final Object reason )
  {
    return Promise.reject( reason );
  }

  public static <V> Promise<V> Promise( final PromiseExecutor<V> executor )
  {
    return new Promise<>( executor );
  }

  public static <T, V> Promise<V> then( final Promise<T> $instance,
                                        final OnFulfilledCallback<? super T, ? extends V> onFulfilled )
  {
    return $instance.then( onFulfilled );
  }

  public static <V> Promise<Void> thenAccept( final Promise<V> $instance, final AcceptCallback<? super V> onAccept )
  {
    return $instance.thenAccept( onAccept );
  }

  public static <V> Promise<V> catch_( final Promise<V> $instance, final OnRejectedCallback<? extends V> onRejected )
  {
    return $instance.catch_( onRejected );
  }

  public static <T, V> Promise<V> then( final Promise<T> $instance,
                                        final OnFulfilledCallback<? super T, ? extends V> onFulfilled,
                                        final OnRejectedCallback<? extends V> onRejected )
  {
    return $instance.then( onFulfilled, onRejected );
  }

  public static <V> Promise<V> finally_( final Promise<V> $instance, final OnSettledCallback onSettle )
  {
    return $instance.finally_( onSettle );
  }
}
