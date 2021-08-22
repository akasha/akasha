package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "$wnd"
)
public final class WindowGlobal {
  /**
   * @deprecated
   */
  @Deprecated
  @JsNonNull
  public static String name;

  private WindowGlobal() {
  }

  /**
   * @deprecated
   */
  @JsProperty(
      name = "isSecureContext"
  )
  @Deprecated
  public static native boolean isSecureContext();

  @JsOverlay
  public static void addEndListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void addEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    addEventListener( "end", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void addEndListener(@Nonnull final EventListener callback) {
    addEventListener( "end", Js.cast( callback ) );
  }

  @JsOverlay
  public static void removeEndListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public static void removeEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    removeEventListener( "end", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public static void removeEndListener(@Nonnull final EventListener callback) {
    removeEventListener( "end", Js.cast( callback ) );
  }

  public static native void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      @Nonnull AddEventListenerOptions options);

  public static native void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      boolean options);

  public static native void addEventListener(@Nonnull String type,
      @Nullable EventListener callback);

  /**
   * Dispatches an Event at the specified EventTarget, (synchronously) invoking the affected EventListeners in the appropriate order. The normal event processing rules (including the capturing and optional bubbling phase) also apply to events dispatched manually with dispatchEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/dispatchEvent">EventTarget.dispatchEvent - MDN</a>
   */
  public static native boolean dispatchEvent(@Nonnull Event event);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@Nonnull String type,
      @Nullable EventListener callback, @Nonnull EventListenerOptions options);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@Nonnull String type,
      @Nullable EventListener callback, boolean options);

  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  public static native void removeEventListener(@Nonnull String type,
      @Nullable EventListener callback);
}
