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
    name = "EventInit"
)
public interface EventInit {
  @JsOverlay
  @Nonnull
  static Builder create(final boolean cancelable) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).cancelable( cancelable );
  }

  /**
   * Documentation for required member EventInit.cancelable.
   */
  @JsProperty(
      name = "cancelable"
  )
  boolean cancelable();

  /**
   * Documentation for required member EventInit.cancelable.
   */
  @JsProperty
  void setCancelable(boolean cancelable);

  /**
   * Documentation for member EventInit.bubbles.
   */
  @JsProperty(
      name = "bubbles"
  )
  boolean bubbles();

  /**
   * Documentation for member EventInit.bubbles.
   */
  @JsProperty
  void setBubbles(boolean bubbles);

  /**
   * Documentation for EventInit.
   */
  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventInit"
  )
  interface Builder extends EventInit {
    /**
     * Documentation for required member EventInit.cancelable.
     */
    @JsOverlay
    @Nonnull
    default Builder cancelable(final boolean cancelable) {
      setCancelable( cancelable );
      return this;
    }

    /**
     * Documentation for member EventInit.bubbles.
     */
    @JsOverlay
    @Nonnull
    default Builder bubbles(final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }
  }
}
