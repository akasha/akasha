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
public interface Dictionary_requiredNullableDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleFrozenArrayValue create(
      @Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
    return Js.<Dictionary_requiredNullableDoubleFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> requiredNullableDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredNullableDoubleFrozenArrayValue(
      @Nullable JsArray<Double> requiredNullableDoubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDoubleFrozenArrayValue requiredNullableDoubleFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
    setRequiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
    return this;
  }
}
