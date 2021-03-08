package elemental3.promise;

import elemental3.lang.JsArray;
import elemental3.lang.JsIterable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The Promise object represents the eventual completion (or failure) of an asynchronous operation and its resulting value.
 *
 * <p>A Promise is a proxy for a value not necessarily known when the promise is created. It allows you to
 * associate handlers with an asynchronous action's eventual success value or failure reason. This lets
 * asynchronous methods return values like synchronous methods: instead of immediately returning the final
 * value, the asynchronous method returns a promise to supply the value at some point in the future.</p>
 *
 * <p>A Promise is in one of these states:</p>
 * <ul>
 * <li><code>pending</code>: initial state, neither fulfilled nor rejected.</li>
 * <li><code>fulfilled</code>: meaning that the operation was completed successfully.</li>
 * <li><code>rejected</code>: meaning that the operation failed.</li>
 * </ul>
 *
 * <p>A pending promise can either be fulfilled with a value or rejected with a reason (error). When either
 * of these options happens, the associated handlers queued up by a promise's then method are called. If the
 * promise has already been fulfilled or rejected when a corresponding handler is attached, the handler will
 * be called, so there is no race condition between an asynchronous operation completing and its handlers being
 * attached.</p>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise">Promise - MDN</a>
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Promise" )
public class Promise<T>
{
  /**
   * The Promise.all() method takes an iterable of promises as an input, and returns a single Promise
   * that resolves to an array of the results of the input promises. This returned promise will resolve
   * when all of the input's promises have resolved, or if the input iterable contains no promises. It
   * rejects immediately upon any of the input promises rejecting or non-promises throwing an error, and
   * will reject with this first rejection message / error.
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise returned.
   * @return the result promise.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/all">Promise.all - MDN</a>
   */
  @SafeVarargs
  @Nonnull
  @JsOverlay
  @SuppressWarnings( "varargs" )
  public static <V> Promise<JsArray<V>> all( @Nonnull final Promise<? extends V>... promises )
  {
    return all( JsArray.of( promises ) );
  }

  /**
   * The Promise.all() method takes an iterable of promises as an input, and returns a single Promise
   * that resolves to an array of the results of the input promises. This returned promise will resolve
   * when all of the input's promises have resolved, or if the input iterable contains no promises. It
   * rejects immediately upon any of the input promises rejecting or non-promises throwing an error, and
   * will reject with this first rejection message / error.
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise results.
   * @return the result promise.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/all">Promise.all - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<JsArray<V>> all( @Nonnull JsIterable<Promise<? extends V>> promises );

  /**
   * Promise.any() takes an iterable of Promise objects and, as soon as one of the promises in the
   * iterable fulfills, returns a single promise that resolves with the value from that promise. If no
   * promises in the iterable fulfill (if all of the given promises are rejected), then the returned
   * promise is rejected with an AggregateError, a new subclass of Error that groups together individual
   * errors. Essentially, this method is the opposite of Promise.all().
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise returned.
   * @return A promise that yields the value of the first promise in the given iterable to fulfill or an {@link elemental3.core.AggregateError} containing the reasons for all the rejected promises.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/any">Promise.any - MDN</a>
   */
  @SafeVarargs
  @Nonnull
  @JsOverlay
  @SuppressWarnings( "varargs" )
  public static <V> Promise<V> any( @Nonnull final Promise<? extends V>... promises )
  {
    return any( JsArray.of( promises ) );
  }

  /**
   * Promise.any() takes an iterable of Promise objects and, as soon as one of the promises in the
   * iterable fulfills, returns a single promise that resolves with the value from that promise. If no
   * promises in the iterable fulfill (if all of the given promises are rejected), then the returned
   * promise is rejected with an AggregateError, a new subclass of Error that groups together individual
   * errors. Essentially, this method is the opposite of Promise.all().
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise returned.
   * @return A promise that yields the value of the first promise in the given iterable to fulfill or an {@link elemental3.core.AggregateError} containing the reasons for all the rejected promises.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/any">Promise.any - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<V> any( @Nonnull JsIterable<Promise<? extends V>> promises );

  /**
   * The Promise.race() method returns a promise that fulfills or rejects as soon as one of the promises in an iterable fulfills or rejects, with the value or reason from that promise.
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise returned.
   * @return A pending Promise that asynchronously yields the value of the first promise in the given iterable to fulfill or reject.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/race">Promise.race - MDN</a>
   */
  @SafeVarargs
  @Nonnull
  @JsOverlay
  @SuppressWarnings( "varargs" )
  public static <V> Promise<V> race( @Nonnull final Promise<? extends V>... promises )
  {
    return race( JsArray.of( promises ) );
  }

  /**
   * The Promise.race() method returns a promise that fulfills or rejects as soon as one of the promises in an iterable fulfills or rejects, with the value or reason from that promise.
   *
   * @param promises the promises.
   * @param <V>      the component type of the promise returned.
   * @return A pending Promise that asynchronously yields the value of the first promise in the given iterable to fulfill or reject.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/race">Promise.race - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<V> race( @Nonnull JsIterable<Promise<? extends V>> promises );

  /**
   * Returns a new Promise object that is resolved with the given value.
   *
   * @param value the promise to wrap and return.
   * @param <V>   the component type of the promise returned.
   * @return a Promise that is resolved with the given value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/resolve">Promise.resolve - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<V> resolve( @Nullable Promise<V> value );

  /**
   * Returns a new Promise object that is resolved with the given value. If the value is a thenable (i.e. has
   * a then method), the returned promise will "follow" that thenable, adopting its eventual state; otherwise,
   * the returned promise will be fulfilled with the value.
   *
   * <p>Generally, if you don't know if a value is a promise or not, Promise.resolve(value) it instead and work
   * with the return value as a promise.</p>
   *
   * @param value the value to use when creating the promise.
   * @param <V>   the component type of the promise returned.
   * @return a Promise that is resolved with the given value.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/resolve">Promise.resolve - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<V> resolve( @Nullable V value );

  /**
   * Returns a new Promise object that is rejected with the given reason.
   *
   * @param reason the reason to reject promise with.
   * @param <V>    the component type of the promise returned.
   * @return a promise that is rejected with the given reason.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/reject">Promise.reject - MDN</a>
   */
  @Nonnull
  public static native <V> Promise<V> reject( @Nullable Object reason );

  /**
   * Creates a new Promise object. The constructor is primarily used to wrap functions that do not already support promises.
   *
   * @param executor a function executed by the constructor during the process of constructing the promise. The executor is custom code that ties an outcome to a promise.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/Promise">Promise() - MDN</a>
   */
  @SuppressWarnings( "unused" )
  public Promise( @Nonnull final PromiseExecutor<T> executor )
  {
  }

  /**
   * Appends the fulfillment handler to the promise, and returns a new promise resolving to the
   * return value of the called handler.
   *
   * @param onFulfilled the callback function called when the promise is fulfilled.
   * @param <V>         the component type of the promise returned from the callback.
   * @return a Promise with the fulfillment handler set to the specified callback.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then">Promise.then - MDN</a>
   */
  @Nonnull
  public native <V> Promise<V> then( @Nonnull OnFulfilledCallback<? super T, ? extends V> onFulfilled );

  /**
   * Appends the fulfillment handler to the promise, and returns a new promise resolving to a void value.
   * This is an affordance added to simplify integration with a java-esque library and is equivalent to a
   * javascript then method that returns undefined.
   *
   * @param onAccept the callback function called when the promise is fulfilled.
   * @return a promise with the fulfillment handler set to the specified callback.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then">Promise.then - MDN</a>
   */
  @JsMethod( name = "then" )
  @Nonnull
  public native Promise<Void> thenAccept( @Nonnull AcceptCallback<? super T> onAccept );

  /**
   * Appends a rejection handler callback to the promise, and returns a new promise resolving to the
   * return value of the callback if it is called, or to its original fulfillment value if the promise
   * is instead fulfilled.
   *
   * @param onRejected the callback function called when the promise is rejected.
   * @param <V>        the component type of the promise returned from the callback.
   * @return a Promise with the rejection handler set to the specified callback.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/catch">Promise.catch - MDN</a>
   */
  @JsMethod( name = "catch" )
  @Nonnull
  public native <V> Promise<V> catch_( @Nonnull OnRejectedCallback<? extends V> onRejected );

  /**
   * Appends fulfillment and rejection handlers to the promise, and returns a new promise resolving to the
   * return value of the called handler, or to its original settled value if the promise was not handled
   * (i.e. if the relevant handler onFulfilled or onRejected is not a function).
   *
   * @param onFulfilled the callback function called when the promise is fulfilled.
   * @param onRejected  the callback function called when the promise is rejected.
   * @param <V>         the component type of the promise returned from the callback.
   * @return a Promise with the fulfillment handler set to the specified callback.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/then">Promise.then - MDN</a>
   */
  @Nonnull
  public native <V> Promise<V> then( @Nullable OnFulfilledCallback<? super T, ? extends V> onFulfilled,
                                     @Nullable OnRejectedCallback<? extends V> onRejected );

  /**
   * The finally() method returns a Promise. When the promise is settled, i.e either fulfilled or rejected,
   * the specified callback function is executed. This provides a way for code to be run whether the promise
   * was fulfilled successfully or rejected once the Promise has been dealt with.
   *
   * @param onSettle a callback function called when the Promise is settled.
   * @return a Promise with the finally handler set to the specified callback.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/finally">Promise.finally - MDN</a>
   */
  @JsMethod( name = "finally" )
  @Nonnull
  public native Promise<T> finally_( OnSettledCallback onSettle );
}
