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
public interface Dictionary_requiredNullableUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnsignedLongValue create(
      @Nullable final Double requiredNullableUnsignedLongValue) {
    return Js.<Dictionary_requiredNullableUnsignedLongValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnsignedLongValue( requiredNullableUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedLongValue"
  )
  @Nullable
  Double requiredNullableUnsignedLongValue();

  @JsProperty
  void setRequiredNullableUnsignedLongValue(@Nullable Double requiredNullableUnsignedLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUnsignedLongValue requiredNullableUnsignedLongValue(
      @Nullable final Double requiredNullableUnsignedLongValue) {
    setRequiredNullableUnsignedLongValue( requiredNullableUnsignedLongValue );
    return this;
  }
}
