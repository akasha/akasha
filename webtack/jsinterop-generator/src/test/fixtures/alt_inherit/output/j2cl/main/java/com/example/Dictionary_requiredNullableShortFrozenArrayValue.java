package com.example;

import com.other.JsArray;
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
    name = "Dictionary_requiredNullableShortFrozenArrayValue"
)
public interface Dictionary_requiredNullableShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsArray<Double> requiredNullableShortFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortFrozenArrayValue( requiredNullableShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableShortFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableShortFrozenArrayValue();

  @JsProperty
  void setRequiredNullableShortFrozenArrayValue(
      @JsNullable JsArray<Double> requiredNullableShortFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableShortFrozenArrayValue"
  )
  interface Builder extends Dictionary_requiredNullableShortFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableShortFrozenArrayValue(
        @Nullable final JsArray<Double> requiredNullableShortFrozenArrayValue) {
      setRequiredNullableShortFrozenArrayValue( requiredNullableShortFrozenArrayValue );
      return this;
    }
  }
}
