package elemental3.promise;

import jsinterop.annotations.JsFunction;

/**
 * The callback function invoked when the promise is fulfilled.
 *
 * @param <T> the type of the value with which the promise was fulfilled.
 */
@JsFunction
public interface AcceptCallback<T>
{
  /**
   * The callback function.
   *
   * @param value the value that the promise was resolved with.
   */
  void onFulfilled( T value );
}
