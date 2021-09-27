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
    name = "Object"
)
public interface Dictionary_requiredDoubleSequenceSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
  }

  @JsOverlay
  @Nonnull
  @SuppressWarnings("unchecked")
  static Builder requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
  }

  @JsProperty(
      name = "requiredDoubleSequenceSequenceValue"
  )
  @JsNonNull
  JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue();

  @JsProperty
  void setRequiredDoubleSequenceSequenceValue(
      @JsNonNull JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue);

  @JsOverlay
  @SuppressWarnings("unchecked")
  default void setRequiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    setRequiredDoubleSequenceSequenceValue( Js.<JsArray<JsArray<Double>>>uncheckedCast( requiredDoubleSequenceSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredDoubleSequenceSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredDoubleSequenceSequenceValue(
        @Nonnull final JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue) {
      setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    @SuppressWarnings("unchecked")
    default Builder requiredDoubleSequenceSequenceValue(
        @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
      setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
      return this;
    }
  }
}
