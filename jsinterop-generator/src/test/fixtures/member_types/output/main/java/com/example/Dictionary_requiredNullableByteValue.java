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
    name = "Object"
)
public interface Dictionary_requiredNullableByteValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableByteValue create(
      @Nullable final Double requiredNullableByteValue) {
    return Js.<Dictionary_requiredNullableByteValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableByteValue( requiredNullableByteValue );
  }

  @JsProperty(
      name = "requiredNullableByteValue"
  )
  @Nullable
  Double requiredNullableByteValue();

  @JsProperty
  void setRequiredNullableByteValue(@Nullable Double requiredNullableByteValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableByteValue requiredNullableByteValue(
      @Nullable final Double requiredNullableByteValue) {
    setRequiredNullableByteValue( requiredNullableByteValue );
    return this;
  }
}
