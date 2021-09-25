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
    name = "Dictionary_requiredNullableShortSequenceValue"
)
public interface Dictionary_requiredNullableShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableShortSequenceValue(
      @Nullable final JsArray<Double> requiredNullableShortSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredNullableShortSequenceValue(
      @Nullable final double[] requiredNullableShortSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableShortSequenceValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableShortSequenceValue();

  @JsProperty
  void setRequiredNullableShortSequenceValue(
      @JsNullable JsArray<Double> requiredNullableShortSequenceValue);

  @JsOverlay
  default void setRequiredNullableShortSequenceValue(
      @Nullable final double... requiredNullableShortSequenceValue) {
    setRequiredNullableShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableShortSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableShortSequenceValue"
  )
  interface Builder extends Dictionary_requiredNullableShortSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableShortSequenceValue(
        @Nullable final JsArray<Double> requiredNullableShortSequenceValue) {
      setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredNullableShortSequenceValue(
        @Nullable final double... requiredNullableShortSequenceValue) {
      setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
      return this;
    }
  }
}
