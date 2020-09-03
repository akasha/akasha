package com.example;

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
public interface Dictionary_requiredNullableDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleValue create(
      @Nullable final Double requiredNullableDoubleValue) {
    return Js.<Dictionary_requiredNullableDoubleValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleValue( requiredNullableDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleValue"
  )
  @Nullable
  Double requiredNullableDoubleValue();

  @JsProperty
  void setRequiredNullableDoubleValue(@Nullable Double requiredNullableDoubleValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDoubleValue requiredNullableDoubleValue(
      @Nullable final Double requiredNullableDoubleValue) {
    setRequiredNullableDoubleValue( requiredNullableDoubleValue );
    return this;
  }
}
