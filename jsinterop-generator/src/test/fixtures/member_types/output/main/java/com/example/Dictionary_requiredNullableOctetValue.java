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
public interface Dictionary_requiredNullableOctetValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableOctetValue create(
      @Nullable final Double requiredNullableOctetValue) {
    return Js.<Dictionary_requiredNullableOctetValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableOctetValue( requiredNullableOctetValue );
  }

  @JsProperty(
      name = "requiredNullableOctetValue"
  )
  @Nullable
  Double requiredNullableOctetValue();

  @JsProperty
  void setRequiredNullableOctetValue(@Nullable Double requiredNullableOctetValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableOctetValue requiredNullableOctetValue(
      @Nullable final Double requiredNullableOctetValue) {
    setRequiredNullableOctetValue( requiredNullableOctetValue );
    return this;
  }
}
