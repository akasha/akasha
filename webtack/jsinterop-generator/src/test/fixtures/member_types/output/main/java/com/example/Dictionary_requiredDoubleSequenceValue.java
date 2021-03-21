package com.example;

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
    name = "Object"
)
public interface Dictionary_requiredDoubleSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceValue create(
      @Nonnull final JsArray<Double> requiredDoubleSequenceValue) {
    return Js.<Dictionary_requiredDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceValue( requiredDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceValue create(
      @Nonnull final double[] requiredDoubleSequenceValue) {
    return Js.<Dictionary_requiredDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceValue( requiredDoubleSequenceValue );
  }

  @JsProperty(
      name = "requiredDoubleSequenceValue"
  )
  @Nonnull
  JsArray<Double> requiredDoubleSequenceValue();

  @JsProperty
  void setRequiredDoubleSequenceValue(@Nonnull JsArray<Double> requiredDoubleSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDoubleSequenceValue requiredDoubleSequenceValue(
      @Nonnull final JsArray<Double> requiredDoubleSequenceValue) {
    setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredDoubleSequenceValue(
      @Nonnull final double... requiredDoubleSequenceValue) {
    setRequiredDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDoubleSequenceValue requiredDoubleSequenceValue(
      @Nonnull final double... requiredDoubleSequenceValue) {
    setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
    return this;
  }
}
