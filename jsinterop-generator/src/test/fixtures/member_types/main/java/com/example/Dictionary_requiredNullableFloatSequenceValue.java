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
public interface Dictionary_requiredNullableFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatSequenceValue create(
      @Nullable final JsArray<Double> requiredNullableFloatSequenceValue) {
    return Js.<Dictionary_requiredNullableFloatSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatSequenceValue create(
      @Nullable final Double[] requiredNullableFloatSequenceValue) {
    return Js.<Dictionary_requiredNullableFloatSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableFloatSequenceValue"
  )
  @Nullable
  JsArray<Double> requiredNullableFloatSequenceValue();

  @JsProperty
  void setRequiredNullableFloatSequenceValue(
      @Nullable JsArray<Double> requiredNullableFloatSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableFloatSequenceValue requiredNullableFloatSequenceValue(
      @Nullable final JsArray<Double> requiredNullableFloatSequenceValue) {
    setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredNullableFloatSequenceValue(
      @Nullable final Double... requiredNullableFloatSequenceValue) {
    setRequiredNullableFloatSequenceValue( JsArray.asJsArray( requiredNullableFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableFloatSequenceValue requiredNullableFloatSequenceValue(
      @Nullable final Double... requiredNullableFloatSequenceValue) {
    setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
    return this;
  }
}
