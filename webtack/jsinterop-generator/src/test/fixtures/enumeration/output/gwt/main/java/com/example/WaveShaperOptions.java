package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Optional attribute is an enum
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface WaveShaperOptions {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "oversample"
  )
  @OverSampleType
  String oversample();

  @JsProperty
  void setOversample(@OverSampleType @JsNonNull String oversample);

  /**
   * Optional attribute is an enum
   */
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends WaveShaperOptions {
    @JsOverlay
    @Nonnull
    default Builder oversample(@OverSampleType @Nonnull final String oversample) {
      setOversample( oversample );
      return this;
    }
  }
}
