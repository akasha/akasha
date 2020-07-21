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
public interface EventListenerOptions {
  @JsOverlay
  @Nonnull
  static EventListenerOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  boolean isCapture();

  @JsProperty
  void setCapture(boolean capture);

  @JsOverlay
  @Nonnull
  default EventListenerOptions capture(boolean capture) {
    setCapture( capture );
    return this;
  }
}
