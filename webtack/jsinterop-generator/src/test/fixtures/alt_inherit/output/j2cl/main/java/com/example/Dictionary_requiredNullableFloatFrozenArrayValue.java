package com.example;

import com.other.JsArray;
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
    name = "Dictionary_requiredNullableFloatFrozenArrayValue"
)
public interface Dictionary_requiredNullableFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsArray<Double> requiredNullableFloatFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatFrozenArrayValue( requiredNullableFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableFloatFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> requiredNullableFloatFrozenArrayValue();

  @JsProperty
  void setRequiredNullableFloatFrozenArrayValue(
      @Nullable JsArray<Double> requiredNullableFloatFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableFloatFrozenArrayValue"
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
