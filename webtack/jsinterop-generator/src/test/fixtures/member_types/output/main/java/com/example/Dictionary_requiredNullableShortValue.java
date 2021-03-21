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
public interface Dictionary_requiredNullableShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortValue create(
      @Nullable final Double requiredNullableShortValue) {
    return Js.<Dictionary_requiredNullableShortValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortValue( requiredNullableShortValue );
  }

  @JsProperty(
      name = "requiredNullableShortValue"
  )
  @Nullable
  Double requiredNullableShortValue();

  @JsProperty
  void setRequiredNullableShortValue(@Nullable Double requiredNullableShortValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableShortValue requiredNullableShortValue(
      @Nullable final Double requiredNullableShortValue) {
    setRequiredNullableShortValue( requiredNullableShortValue );
    return this;
  }
}
