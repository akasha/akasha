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
public interface Dictionary_requiredNullableFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatValue create(
      @Nullable final Double requiredNullableFloatValue) {
    return Js.<Dictionary_requiredNullableFloatValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatValue( requiredNullableFloatValue );
  }

  @JsProperty(
      name = "requiredNullableFloatValue"
  )
  @Nullable
  Double requiredNullableFloatValue();

  @JsProperty
  void setRequiredNullableFloatValue(@Nullable Double requiredNullableFloatValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableFloatValue requiredNullableFloatValue(
      @Nullable final Double requiredNullableFloatValue) {
    setRequiredNullableFloatValue( requiredNullableFloatValue );
    return this;
  }
}
