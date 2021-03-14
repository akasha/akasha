package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.base.Js;

/**
 * Accessor for the global <b>globalThis</b> property also know as the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
public final class Global {
  private static GlobalWindow globalThis;

  private Global() {
  }

  /**
   * Accessor for the global <b>globalThis</b> property contains the global <i>this</i> value, which is akin to the global object.
   *
   * @return the global object
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
   */
  @Nonnull
  public static GlobalWindow globalThis() {
    return Js.uncheckedCast( Js.global() );
  }

  /**
   * @deprecated
   */
  @Deprecated
  public static boolean isSecureContext() {
    return globalThis().isSecureContext();
  }

  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public static String name() {
    return globalThis().name;
  }

  public static void addEndListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    globalThis().addEndListener( callback, options );
  }

  public static void addEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().addEndListener( callback, useCapture );
  }

  public static void addEndListener(@Nonnull final EventListener callback) {
    globalThis().addEndListener( callback );
  }

  public static void removeEndListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    globalThis().removeEndListener( callback, options );
  }

  public static void removeEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().removeEndListener( callback, useCapture );
  }

  public static void removeEndListener(@Nonnull final EventListener callback) {
    globalThis().removeEndListener( callback );
  }

  public static void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      @Nonnull AddEventListenerOptions options) {
    globalThis().addEventListener(type, callback, options);
  }

  public static void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      boolean options) {
    globalThis().addEventListener(type, callback, options);
  }

  public static void addEventListener(@Nonnull String type, @Nullable EventListener callback) {
    globalThis().addEventListener(type, callback);
  }

  /**
   * Dispatches an Event at the specified EventTarget, (synchronously) invoking the affected EventListeners in the appropriate order. The normal event processing rules (including the capturing and optional bubbling phase) also apply to events dispatched manually with dispatchEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/dispatchEvent">EventTarget.dispatchEvent - MDN</a>
   */
  public static boolean dispatchEvent(@Nonnull Event event) {
    return globalThis().dispatchEvent(event);
  }

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static void removeEventListener(@Nonnull String type, @Nullable EventListener callback,
      @Nonnull EventListenerOptions options) {
    globalThis().removeEventListener(type, callback, options);
  }

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static void removeEventListener(@Nonnull String type, @Nullable EventListener callback,
      boolean options) {
    globalThis().removeEventListener(type, callback, options);
  }

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static void removeEventListener(@Nonnull String type, @Nullable EventListener callback) {
    globalThis().removeEventListener(type, callback);
  }

  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public static String decodeURI(@Nonnull String encodedURI) {
    return globalThis().decodeURI(encodedURI);
  }

  @Nonnull
  public static CSSNamespace css() {
    return globalThis().css();
  }
}
