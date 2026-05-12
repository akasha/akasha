package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "RTCAnswerOptions"
)
public interface RTCAnswerOptions extends RTCOfferAnswerOptions {
  @JsOverlay
  @Nonnull
  static RTCAnswerOptions of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }
}
