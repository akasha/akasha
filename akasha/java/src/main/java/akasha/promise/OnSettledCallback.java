package akasha.promise;

import jsinterop.annotations.JsFunction;

/**
 * The callback function invoked when the promise settles.
 */
@JsFunction
public interface OnSettledCallback
{
  /**
   * The callback function.
   */
  void onSettled();
}
