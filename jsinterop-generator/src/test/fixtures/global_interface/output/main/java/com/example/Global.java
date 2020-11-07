package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Accessor for the global <b>globalThis</b> property also know as the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
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
  @JsOverlay
  @Nonnull
  public static GlobalWindow globalThis() {
    return globalThis;
  }

  public static boolean closed() {
    return globalThis().closed();
  }

  /**
   * The window.isSecureContext read-only property indicates whether a context is capable of using features that require secure contexts.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/isSecureContext">Window.isSecureContext - MDN</a>
   * @see <a href="https://w3c.github.io/webappsec-secure-contexts/">Secure Contexts</a>
   */
  public static boolean isSecureContext() {
    return globalThis().isSecureContext();
  }

  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  @Nonnull
  public static String name() {
    return globalThis().name;
  }

  public static void scroll(double x, double y) {
    globalThis().scroll(x, y);
  }

  public static void scroll(@Nonnull ScrollToOptions options) {
    globalThis().scroll(options);
  }

  public static void scroll() {
    globalThis().scroll();
  }

  @Nonnull
  public static Object get(@Nonnull String name) {
    return globalThis().get(name);
  }

  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    globalThis().addDOMContentLoadedListener( callback, options );
  }

  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().addDOMContentLoadedListener( callback, useCapture );
  }

  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback) {
    globalThis().addDOMContentLoadedListener( callback );
  }

  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    globalThis().removeDOMContentLoadedListener( callback, options );
  }

  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().removeDOMContentLoadedListener( callback, useCapture );
  }

  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback) {
    globalThis().removeDOMContentLoadedListener( callback );
  }

  public static void addFocusListener(@Nonnull final FocusEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    globalThis().addFocusListener( callback, options );
  }

  public static void addFocusListener(@Nonnull final FocusEventListener callback,
      final boolean useCapture) {
    globalThis().addFocusListener( callback, useCapture );
  }

  public static void addFocusListener(@Nonnull final FocusEventListener callback) {
    globalThis().addFocusListener( callback );
  }

  public static void removeFocusListener(@Nonnull final FocusEventListener callback,
      @Nonnull final EventListenerOptions options) {
    globalThis().removeFocusListener( callback, options );
  }

  public static void removeFocusListener(@Nonnull final FocusEventListener callback,
      final boolean useCapture) {
    globalThis().removeFocusListener( callback, useCapture );
  }

  public static void removeFocusListener(@Nonnull final FocusEventListener callback) {
    globalThis().removeFocusListener( callback );
  }

  @Nonnull
  public static String id() {
    return globalThis().id;
  }

  public static boolean open() {
    return globalThis().open();
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

  public static void addBingListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    globalThis().addBingListener( callback, options );
  }

  public static void addBingListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().addBingListener( callback, useCapture );
  }

  public static void addBingListener(@Nonnull final EventListener callback) {
    globalThis().addBingListener( callback );
  }

  public static void removeBingListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    globalThis().removeBingListener( callback, options );
  }

  public static void removeBingListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    globalThis().removeBingListener( callback, useCapture );
  }

  public static void removeBingListener(@Nonnull final EventListener callback) {
    globalThis().removeBingListener( callback );
  }
}
