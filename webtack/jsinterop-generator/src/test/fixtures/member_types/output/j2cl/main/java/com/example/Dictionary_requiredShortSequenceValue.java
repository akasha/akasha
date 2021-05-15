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
    name = "Dictionary_requiredShortSequenceValue"
)
public interface Dictionary_requiredShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Double> requiredShortSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredShortSequenceValue( requiredShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final double[] requiredShortSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredShortSequenceValue( requiredShortSequenceValue );
  }

  @JsProperty(
      name = "requiredShortSequenceValue"
  )
  @Nonnull
  JsArray<Double> requiredShortSequenceValue();

  @JsProperty
  void setRequiredShortSequenceValue(@Nonnull JsArray<Double> requiredShortSequenceValue);

  @JsOverlay
  default void setRequiredShortSequenceValue(@Nonnull final double... requiredShortSequenceValue) {
    setRequiredShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredShortSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredShortSequenceValue"
  )
  interface Builder extends Dictionary_requiredShortSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredShortSequenceValue(
        @Nonnull final JsArray<Double> requiredShortSequenceValue) {
      setRequiredShortSequenceValue( requiredShortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredShortSequenceValue(
        @Nonnull final double... requiredShortSequenceValue) {
      setRequiredShortSequenceValue( requiredShortSequenceValue );
      return this;
    }
  }
}
