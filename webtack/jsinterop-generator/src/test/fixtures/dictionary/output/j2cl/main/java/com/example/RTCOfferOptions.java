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
    name = "RTCOfferOptions"
)
public interface RTCOfferOptions extends RTCOfferAnswerOptions {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "iceRestart"
  )
  boolean iceRestart();

  @JsProperty
  void setIceRestart(boolean iceRestart);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "RTCOfferOptions"
  )
  interface Builder extends RTCOfferOptions {
    @JsOverlay
    @Nonnull
    default Builder iceRestart(final boolean iceRestart) {
      setIceRestart( iceRestart );
      return this;
    }
  }
}
