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
public interface Dictionary_requiredNullableUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnsignedShortValue create(
      @Nullable final Double requiredNullableUnsignedShortValue) {
    return Js.<Dictionary_requiredNullableUnsignedShortValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnsignedShortValue( requiredNullableUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedShortValue"
  )
  @Nullable
  Double requiredNullableUnsignedShortValue();

  @JsProperty
  void setRequiredNullableUnsignedShortValue(@Nullable Double requiredNullableUnsignedShortValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUnsignedShortValue requiredNullableUnsignedShortValue(
      @Nullable final Double requiredNullableUnsignedShortValue) {
    setRequiredNullableUnsignedShortValue( requiredNullableUnsignedShortValue );
    return this;
  }
}
