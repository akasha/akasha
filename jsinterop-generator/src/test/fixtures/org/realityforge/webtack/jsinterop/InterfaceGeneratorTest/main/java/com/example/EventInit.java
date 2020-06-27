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

  @JsProperty
  boolean isCancelable();

  @JsProperty
  void setCancelable(boolean cancelable);

  @JsProperty
  boolean isComposed();

  @JsProperty
  void setComposed(boolean composed);
}
