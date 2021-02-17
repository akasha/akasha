package com.example;

import elemental3.lang.JsArray;
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
public interface Dictionary_requiredNullableShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortFrozenArrayValue create(
      @Nullable final JsArray<Double> requiredNullableShortFrozenArrayValue) {
    return Js.<Dictionary_requiredNullableShortFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortFrozenArrayValue( requiredNullableShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableShortFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> requiredNullableShortFrozenArrayValue();

  @JsProperty
  void setRequiredNullableShortFrozenArrayValue(
      @Nullable JsArray<Double> requiredNullableShortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableShortFrozenArrayValue requiredNullableShortFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableShortFrozenArrayValue) {
    setRequiredNullableShortFrozenArrayValue( requiredNullableShortFrozenArrayValue );
    return this;
  }
}
