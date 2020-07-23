package com.example;

import elemental2.core.Float64Array;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface Dictionary_requiredNullableFloat64ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloat64ArrayValue create(
      @Nullable final Float64Array requiredNullableFloat64ArrayValue) {
    return Js.<Dictionary_requiredNullableFloat64ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloat64ArrayValue( requiredNullableFloat64ArrayValue );
  }

  @JsProperty
  @Nullable
  Float64Array getRequiredNullableFloat64ArrayValue();

  @JsProperty
  void setRequiredNullableFloat64ArrayValue(
      @Nullable Float64Array requiredNullableFloat64ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableFloat64ArrayValue requiredNullableFloat64ArrayValue(
      @Nullable final Float64Array requiredNullableFloat64ArrayValue) {
    setRequiredNullableFloat64ArrayValue( requiredNullableFloat64ArrayValue );
    return this;
  }
}
