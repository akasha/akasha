package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Optional attribute is an enum
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface WaveShaperOptions {
  @JsOverlay
  @Nonnull
  static WaveShaperOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "oversample"
  )
  @MagicConstant(
      valuesFromClass = OverSampleType.class
  )
  String oversample();

  @JsProperty
  void setOversample(
      @MagicConstant(valuesFromClass = OverSampleType.class) @Nonnull String oversample);

  @JsOverlay
  @Nonnull
  default WaveShaperOptions oversample(
      @MagicConstant(valuesFromClass = OverSampleType.class) @Nonnull final String oversample) {
    setOversample( oversample );
    return this;
  }
}
