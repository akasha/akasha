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
    name = "Object"
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
      @Nullable final double[] requiredNullableDoubleSequenceValue) {
    return Js.<Dictionary_requiredNullableDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleSequenceValue"
  )
  @Nullable
  JsArray<Double> requiredNullableDoubleSequenceValue();

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
      @Nullable final double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDoubleSequenceValue requiredNullableDoubleSequenceValue(
      @Nullable final double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
    return this;
  }
}
