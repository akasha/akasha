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
public interface Dictionary_requiredShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortSequenceValue create(
      @Nonnull final JsArray<Double> requiredShortSequenceValue) {
    return Js.<Dictionary_requiredShortSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredShortSequenceValue( requiredShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortSequenceValue create(
      @Nonnull final Double[] requiredShortSequenceValue) {
    return Js.<Dictionary_requiredShortSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredShortSequenceValue( requiredShortSequenceValue );
  }

  @JsProperty
  @Nonnull
  JsArray<Double> getRequiredShortSequenceValue();

  @JsProperty
  void setRequiredShortSequenceValue(@Nonnull JsArray<Double> requiredShortSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredShortSequenceValue requiredShortSequenceValue(
      @Nonnull final JsArray<Double> requiredShortSequenceValue) {
    setRequiredShortSequenceValue( requiredShortSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredShortSequenceValue(@Nonnull final Double[] requiredShortSequenceValue) {
    setRequiredShortSequenceValue( JsArray.asJsArray( requiredShortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredShortSequenceValue requiredShortSequenceValue(
      @Nonnull final Double[] requiredShortSequenceValue) {
    setRequiredShortSequenceValue( requiredShortSequenceValue );
    return this;
  }
}
