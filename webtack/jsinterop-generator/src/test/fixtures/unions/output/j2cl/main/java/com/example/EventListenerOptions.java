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
    name = "EventListenerOptions"
)
public interface EventListenerOptions {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "capture"
  )
  boolean capture();

  @JsProperty
  void setCapture(boolean capture);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventListenerOptions"
  )
  interface Builder extends EventListenerOptions {
    @JsOverlay
    @Nonnull
    default Builder capture(final boolean capture) {
      setCapture( capture );
      return this;
    }
  }
}
