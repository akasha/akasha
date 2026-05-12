package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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
  static Builder of() {
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
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  @Deprecated
  interface Builder extends EventInit {
    /**
     * @deprecated
     */
    @JsOverlay
    @Nonnull
    @Deprecated
    default Builder bubbles(final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }
  }
}
