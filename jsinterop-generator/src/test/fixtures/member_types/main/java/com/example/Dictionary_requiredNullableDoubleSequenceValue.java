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
public interface Dictionary_requiredNullableDoubleSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleSequenceValue create(
      @Nullable final JsArray<Double> requiredNullableDoubleSequenceValue) {
    return Js.<Dictionary_requiredNullableDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleSequenceValue create(
      @Nullable final Double[] requiredNullableDoubleSequenceValue) {
    return Js.<Dictionary_requiredNullableDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
  }

  @JsProperty
  @Nullable
  JsArray<Double> getRequiredNullableDoubleSequenceValue();

  @JsProperty
  void setRequiredNullableDoubleSequenceValue(
      @Nullable JsArray<Double> requiredNullableDoubleSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDoubleSequenceValue requiredNullableDoubleSequenceValue(
      @Nullable final JsArray<Double> requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredNullableDoubleSequenceValue(
      @Nullable final Double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( JsArray.asJsArray( requiredNullableDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDoubleSequenceValue requiredNullableDoubleSequenceValue(
      @Nullable final Double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
    return this;
  }
}
