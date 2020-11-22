package com.example;

import elemental3.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public interface Dictionary_requiredFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatSequenceValue create(
      @Nonnull final JsArray<Double> requiredFloatSequenceValue) {
    return Js.<Dictionary_requiredFloatSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredFloatSequenceValue( requiredFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatSequenceValue create(
      @Nonnull final double[] requiredFloatSequenceValue) {
    return Js.<Dictionary_requiredFloatSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredFloatSequenceValue( requiredFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredFloatSequenceValue"
  )
  @Nonnull
  JsArray<Double> requiredFloatSequenceValue();

  @JsProperty
  void setRequiredFloatSequenceValue(@Nonnull JsArray<Double> requiredFloatSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloatSequenceValue requiredFloatSequenceValue(
      @Nonnull final JsArray<Double> requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( requiredFloatSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredFloatSequenceValue(@Nonnull final double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloatSequenceValue requiredFloatSequenceValue(
      @Nonnull final double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( requiredFloatSequenceValue );
    return this;
  }
}
