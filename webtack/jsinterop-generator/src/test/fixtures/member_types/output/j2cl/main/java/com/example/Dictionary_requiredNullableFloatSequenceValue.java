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
    name = "Dictionary_requiredNullableFloatSequenceValue"
)
public interface Dictionary_requiredNullableFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableFloatSequenceValue(
      @Nullable final JsArray<Double> requiredNullableFloatSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredNullableFloatSequenceValue(
      @Nullable final double... requiredNullableFloatSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableFloatSequenceValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableFloatSequenceValue();

  @JsProperty
  void setRequiredNullableFloatSequenceValue(
      @JsNullable JsArray<Double> requiredNullableFloatSequenceValue);

  @JsOverlay
  default void setRequiredNullableFloatSequenceValue(
      @Nullable final double... requiredNullableFloatSequenceValue) {
    setRequiredNullableFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableFloatSequenceValue ) );
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableFloatSequenceValue"
  )
  interface Builder extends Dictionary_requiredNullableFloatSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableFloatSequenceValue(
        @Nullable final JsArray<Double> requiredNullableFloatSequenceValue) {
      setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredNullableFloatSequenceValue(
        @Nullable final double... requiredNullableFloatSequenceValue) {
      setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
      return this;
    }
  }
}
