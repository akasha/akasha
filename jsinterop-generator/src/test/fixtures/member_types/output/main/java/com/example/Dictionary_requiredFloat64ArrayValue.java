package com.example;

import elemental2.core.Float64Array;
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
public interface Dictionary_requiredFloat64ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloat64ArrayValue create(
      @Nonnull final Float64Array requiredFloat64ArrayValue) {
    return Js.<Dictionary_requiredFloat64ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredFloat64ArrayValue( requiredFloat64ArrayValue );
  }

  @JsProperty(
      name = "requiredFloat64ArrayValue"
  )
  @Nonnull
  Float64Array requiredFloat64ArrayValue();

  @JsProperty
  void setRequiredFloat64ArrayValue(@Nonnull Float64Array requiredFloat64ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloat64ArrayValue requiredFloat64ArrayValue(
      @Nonnull final Float64Array requiredFloat64ArrayValue) {
    setRequiredFloat64ArrayValue( requiredFloat64ArrayValue );
    return this;
  }
}
