package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "Dictionary_requiredFloatSequenceValue"
)
public interface Dictionary_requiredFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Double> requiredFloatSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredFloatSequenceValue( requiredFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final double[] requiredFloatSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredFloatSequenceValue( requiredFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredFloatSequenceValue"
  )
  @JsNonNull
  JsArray<Double> requiredFloatSequenceValue();

  @JsProperty
  void setRequiredFloatSequenceValue(@JsNonNull JsArray<Double> requiredFloatSequenceValue);

  @JsOverlay
  default void setRequiredFloatSequenceValue(@Nonnull final double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredFloatSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredFloatSequenceValue"
  )
  interface Builder extends Dictionary_requiredFloatSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredFloatSequenceValue(
        @Nonnull final JsArray<Double> requiredFloatSequenceValue) {
      setRequiredFloatSequenceValue( requiredFloatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredFloatSequenceValue(
        @Nonnull final double... requiredFloatSequenceValue) {
      setRequiredFloatSequenceValue( requiredFloatSequenceValue );
      return this;
    }
  }
}
