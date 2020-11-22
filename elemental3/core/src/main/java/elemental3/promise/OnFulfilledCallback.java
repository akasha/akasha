package elemental3.promise;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;

/**
 * The callback function invoked when the promise is fulfilled.
 *
 * @param <T> the type of the value with which the promise was fulfilled.
 * @param <V> the component type of the promise returned from the callback.
 */
@JsFunction
public interface OnFulfilledCallback<T, V>
{
  /**
   * The callback function.
   *
   * @param value the value that the promise was resolved with.
   * @return the promise to chain to if any.
   */
  @Nullable
  Promise<V> onFulfilled( T value );
}
