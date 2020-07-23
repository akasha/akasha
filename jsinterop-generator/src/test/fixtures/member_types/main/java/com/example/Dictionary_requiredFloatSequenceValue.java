package com.example;

import elemental2.core.JsArray;
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
      @Nonnull final Double[] requiredFloatSequenceValue) {
    return Js.<Dictionary_requiredFloatSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredFloatSequenceValue( requiredFloatSequenceValue );
  }

  @JsProperty
  @Nonnull
  JsArray<Double> getRequiredFloatSequenceValue();

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
  default void setRequiredFloatSequenceValue(@Nonnull final Double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( JsArray.asJsArray( requiredFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloatSequenceValue requiredFloatSequenceValue(
      @Nonnull final Double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( requiredFloatSequenceValue );
    return this;
  }
}
