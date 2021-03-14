package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * @deprecated
 */
@Generated("org.realityforge.webtack")
@Deprecated
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public class Window extends EventTarget {
  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public String name;

  protected Window() {
  }

  /**
   * @deprecated
   */
  @JsProperty(
      name = "isSecureContext"
  )
  @Deprecated
  public native boolean isSecureContext();

  @JsOverlay
  public final void addEndListener(@Nonnull final EventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    addEventListener( "end", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final EventListener callback) {
    addEventListener( "end", Js.cast( callback ) );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final EventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final EventListener callback,
      final boolean useCapture) {
    removeEventListener( "end", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final EventListener callback) {
    removeEventListener( "end", Js.cast( callback ) );
  }
}
