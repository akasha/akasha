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
public interface AudioWorkletNodeOptions {
  @JsOverlay
  @Nonnull
  static AudioWorkletNodeOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  JsPropertyMap<Double> getParameterData();

  @JsProperty
  void setParameterData(@Nonnull JsPropertyMap<Double> parameterData);

  @JsOverlay
  @Nonnull
  default AudioWorkletNodeOptions parameterData(@Nonnull JsPropertyMap<Double> parameterData) {
    setParameterData( parameterData );
    return this;
  }
}
