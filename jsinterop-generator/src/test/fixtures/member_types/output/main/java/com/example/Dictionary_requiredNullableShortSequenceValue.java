package com.example;

import elemental3.core.JsArray;
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
public interface Dictionary_requiredNullableShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortSequenceValue create(
      @Nullable final JsArray<Double> requiredNullableShortSequenceValue) {
    return Js.<Dictionary_requiredNullableShortSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortSequenceValue create(
      @Nullable final double[] requiredNullableShortSequenceValue) {
    return Js.<Dictionary_requiredNullableShortSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableShortSequenceValue"
  )
  @Nullable
  JsArray<Double> requiredNullableShortSequenceValue();

  @JsProperty
  void setRequiredNullableShortSequenceValue(
      @Nullable JsArray<Double> requiredNullableShortSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableShortSequenceValue requiredNullableShortSequenceValue(
      @Nullable final JsArray<Double> requiredNullableShortSequenceValue) {
    setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredNullableShortSequenceValue(
      @Nullable final double... requiredNullableShortSequenceValue) {
    setRequiredNullableShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableShortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableShortSequenceValue requiredNullableShortSequenceValue(
      @Nullable final double... requiredNullableShortSequenceValue) {
    setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
    return this;
  }
}
