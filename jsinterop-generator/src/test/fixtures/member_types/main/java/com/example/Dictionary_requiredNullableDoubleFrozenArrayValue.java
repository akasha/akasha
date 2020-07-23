package com.example;

import elemental2.core.JsArray;
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
public interface Dictionary_requiredNullableDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleFrozenArrayValue create(
      @Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
    return Js.<Dictionary_requiredNullableDoubleFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
  }

  @JsProperty
  @Nullable
  JsArray<Double> getRequiredNullableDoubleFrozenArrayValue();

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
