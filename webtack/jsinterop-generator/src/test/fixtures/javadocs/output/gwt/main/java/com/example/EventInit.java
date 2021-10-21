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
    name = "Object"
)
public interface EventInit {
  @JsOverlay
  @Nonnull
  static Builder cancelable(final boolean cancelable) {
    final Builder $eventInit = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $eventInit.setCancelable( cancelable );
    return Js.uncheckedCast( $eventInit );
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
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends EventInit {
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
