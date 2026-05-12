package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class WindowGlobal {
  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  @JsNonNull
  public static String name;

  @JsNonNull
  public static String id;

  private WindowGlobal() {
  }

  @JsProperty(
      name = "closed"
  )
  public static native boolean closed();

  /**
   * The window.isSecureContext read-only property indicates whether a context is capable of using features that require secure contexts.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/isSecureContext">Window.isSecureContext - MDN</a>
   * @see <a href="https://w3c.github.io/webappsec-secure-contexts/">Secure Contexts</a>
   */
  @JsProperty(
      name = "isSecureContext"
  )
  public static native boolean isSecureContext();

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  public static native Navigator navigator();

  public static native void postMessage(@DoNotAutobox java.lang. @JsNullable Object message,
      @JsNonNull String targetOrigin, @JsNonNull JsArray<Transferable2> transfer);

  @JsOverlay
  public static final void postMessage(@DoNotAutobox final java.lang. @JsNullable Object message,
      final @JsNonNull String targetOrigin, final Transferable2 @JsNonNull ... transfer) {
    _postMessage( message, targetOrigin, transfer );
  }

  @JsMethod(
      name = "postMessage"
  )
  private static native void _postMessage(@DoNotAutobox java.lang. @JsNullable Object message,
      @JsNonNull String targetOrigin, Transferable2 @JsNonNull [] transfer);

  public static native void postMessage(@DoNotAutobox java.lang. @JsNullable Object message,
      @JsNonNull String targetOrigin);

  public static native void scroll(double x, double y);

  public static native void scroll(@JsNonNull ScrollToOptions options);

  public static native void scroll();

  @HasNoSideEffects
  @JsNonNull
  public static native Object get(@JsNonNull String name);

  @JsOverlay
  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "DOMContentLoaded", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    addEventListener( "DOMContentLoaded", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void addDOMContentLoadedListener(@Nonnull final EventListener callback) {
    addEventListener( "DOMContentLoaded", Js.cast( callback ) );
  }

  @JsOverlay
  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "DOMContentLoaded", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    removeEventListener( "DOMContentLoaded", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void removeDOMContentLoadedListener(@Nonnull final EventListener callback) {
    removeEventListener( "DOMContentLoaded", Js.cast( callback ) );
  }

  @JsOverlay
  public static void addFocusListener(@Nonnull final FocusEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "focus", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void addFocusListener(@Nonnull final FocusEventListener callback,
      final boolean useCapture) {
    addEventListener( "focus", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void addFocusListener(@Nonnull final FocusEventListener callback) {
    addEventListener( "focus", Js.cast( callback ) );
  }

  @JsOverlay
  public static void removeFocusListener(@Nonnull final FocusEventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "focus", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void removeFocusListener(@Nonnull final FocusEventListener callback,
      final boolean useCapture) {
    removeEventListener( "focus", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void removeFocusListener(@Nonnull final FocusEventListener callback) {
    removeEventListener( "focus", Js.cast( callback ) );
  }

  @JsProperty(
      name = "open"
  )
  public static native boolean open();

  public static native void addEventListener(@JsNonNull String type,
      @JsNullable EventListener callback, @JsNonNull AddEventListenerOptions options);

  public static native void addEventListener(@JsNonNull String type,
      @JsNullable EventListener callback, boolean options);

  public static native void addEventListener(@JsNonNull String type,
      @JsNullable EventListener callback);

  /**
   * Dispatches an Event at the specified EventTarget, (synchronously) invoking the affected EventListeners in the appropriate order. The normal event processing rules (including the capturing and optional bubbling phase) also apply to events dispatched manually with dispatchEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/dispatchEvent">EventTarget.dispatchEvent - MDN</a>
   */
  public static native boolean dispatchEvent(@JsNonNull Event event);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@JsNonNull String type,
      @JsNullable EventListener callback, @JsNonNull EventListenerOptions options);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@JsNonNull String type,
      @JsNullable EventListener callback, boolean options);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@JsNonNull String type,
      @JsNullable EventListener callback);

  @JsOverlay
  public static void addBingListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "bing", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void addBingListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    addEventListener( "bing", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void addBingListener(@Nonnull final EventListener callback) {
    addEventListener( "bing", Js.cast( callback ) );
  }

  @JsOverlay
  public static void removeBingListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "bing", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void removeBingListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    removeEventListener( "bing", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void removeBingListener(@Nonnull final EventListener callback) {
    removeEventListener( "bing", Js.cast( callback ) );
  }
}
