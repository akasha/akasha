package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
public interface Dictionary_requiredNullableFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableFloatFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableFloatFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatFrozenArrayValue( requiredNullableFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableFloatFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableFloatFrozenArrayValue();

  @JsProperty
  void setRequiredNullableFloatFrozenArrayValue(
      @JsNullable JsArray<Double> requiredNullableFloatFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableFloatFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableFloatFrozenArrayValue(
        @Nullable final JsArray<Double> requiredNullableFloatFrozenArrayValue) {
      setRequiredNullableFloatFrozenArrayValue( requiredNullableFloatFrozenArrayValue );
      return this;
    }
  }
}
