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
  static Builder create(@Nullable final JsArray<Double> requiredNullableDoubleSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final double[] requiredNullableDoubleSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
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
  default void setRequiredNullableDoubleSequenceValue(
      @Nullable final double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableDoubleSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableDoubleSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableDoubleSequenceValue(
        @Nullable final JsArray<Double> requiredNullableDoubleSequenceValue) {
      setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredNullableDoubleSequenceValue(
        @Nullable final double... requiredNullableDoubleSequenceValue) {
      setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
      return this;
    }
  }
}
