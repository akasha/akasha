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
public interface Dictionary_requiredDoubleSequenceSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceSequenceValue create(
      @Nonnull final JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue) {
    return Js.<Dictionary_requiredDoubleSequenceSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceSequenceValue create(
      @Nonnull final JsArray<Double>[] requiredDoubleSequenceSequenceValue) {
    return Js.<Dictionary_requiredDoubleSequenceSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
  }

  @JsProperty
  @Nonnull
  JsArray<JsArray<Double>> getRequiredDoubleSequenceSequenceValue();

  @JsProperty
  void setRequiredDoubleSequenceSequenceValue(
      @Nonnull JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDoubleSequenceSequenceValue requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue) {
    setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
    return this;
  }

  @JsOverlay
  @SuppressWarnings("unchecked")
  default void setRequiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    setRequiredDoubleSequenceSequenceValue( JsArray.asJsArray( requiredDoubleSequenceSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  @SuppressWarnings("unchecked")
  default Dictionary_requiredDoubleSequenceSequenceValue requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
    return this;
  }
}
