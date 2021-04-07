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
public interface Dictionary_requiredNullableDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> requiredNullableDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredNullableDoubleFrozenArrayValue(
      @Nullable JsArray<Double> requiredNullableDoubleFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableDoubleFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableDoubleFrozenArrayValue(
        @Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
      setRequiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
      return this;
    }
  }
}
