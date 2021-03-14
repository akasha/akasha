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
 * @deprecated
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
@Deprecated
public interface EventInit {
  @JsOverlay
  @Nonnull
  static EventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  /**
   * @deprecated
   */
  @JsProperty(
      name = "bubbles"
  )
  @Deprecated
  boolean bubbles();

  /**
   * @deprecated
   */
  @JsProperty
  @Deprecated
  void setBubbles(boolean bubbles);

  /**
   * @deprecated
   */
  @JsOverlay
  @Nonnull
  @Deprecated
  default EventInit bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }
}
