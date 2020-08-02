package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Documentation for EventInit.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface EventInit {
  @JsOverlay
  @Nonnull
  static EventInit create(final boolean cancelable) {
    return Js.<EventInit>uncheckedCast( JsPropertyMap.of() ).cancelable( cancelable );
  }

  /**
   * Documentation for member EventInit.bubbles.
   */
  @JsProperty
  boolean isBubbles();

  /**
   * Documentation for member EventInit.bubbles.
   */
  @JsProperty
  void setBubbles(boolean bubbles);

  /**
   * Documentation for member EventInit.bubbles.
   */
  @JsOverlay
  @Nonnull
  default EventInit bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  /**
   * Documentation for required member EventInit.cancelable.
   */
  @JsProperty
  boolean isCancelable();

  /**
   * Documentation for required member EventInit.cancelable.
   */
  @JsProperty
  void setCancelable(boolean cancelable);

  /**
   * Documentation for required member EventInit.cancelable.
   */
  @JsOverlay
  @Nonnull
  default EventInit cancelable(final boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }
}
