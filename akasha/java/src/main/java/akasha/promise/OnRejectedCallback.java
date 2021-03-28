package akasha.promise;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;

/**
 * The callback function invoked when the promise is rejected.
 *
 * @param <V> the component type of the promise returned from the callback.
 */
@JsFunction
public interface OnRejectedCallback<V>
{
  /**
   * The callback function.
   *
   * @param reason the reason that the promise was rejected with.
   * @return the promise to chain to if any.
   */
  @Nullable
  Promise<V> onRejected( Object reason );
}
