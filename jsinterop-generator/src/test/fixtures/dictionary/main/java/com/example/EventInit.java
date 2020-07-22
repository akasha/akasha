package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface EventInit {
  @JsOverlay
  @Nonnull
  static EventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  boolean isBubbles();

  @JsProperty
  void setBubbles(boolean bubbles);

  @JsOverlay
  @Nonnull
  default EventInit bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsProperty
  boolean isCancelable();

  @JsProperty
  void setCancelable(boolean cancelable);

  @JsOverlay
  @Nonnull
  default EventInit cancelable(final boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsProperty
  boolean isComposed();

  @JsProperty
  void setComposed(boolean composed);

  @JsOverlay
  @Nonnull
  default EventInit composed(final boolean composed) {
    setComposed( composed );
    return this;
  }
}
