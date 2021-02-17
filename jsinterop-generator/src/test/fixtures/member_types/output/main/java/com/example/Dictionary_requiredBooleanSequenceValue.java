package com.example;

import elemental3.lang.JsArray;
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
public interface Dictionary_requiredBooleanSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanSequenceValue create(
      @Nonnull final JsArray<Boolean> requiredBooleanSequenceValue) {
    return Js.<Dictionary_requiredBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredBooleanSequenceValue( requiredBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanSequenceValue create(
      @Nonnull final Boolean[] requiredBooleanSequenceValue) {
    return Js.<Dictionary_requiredBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredBooleanSequenceValue( requiredBooleanSequenceValue );
  }

  @JsProperty(
      name = "requiredBooleanSequenceValue"
  )
  @Nonnull
  JsArray<Boolean> requiredBooleanSequenceValue();

  @JsProperty
  void setRequiredBooleanSequenceValue(@Nonnull JsArray<Boolean> requiredBooleanSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredBooleanSequenceValue requiredBooleanSequenceValue(
      @Nonnull final JsArray<Boolean> requiredBooleanSequenceValue) {
    setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredBooleanSequenceValue(
      @Nonnull final Boolean... requiredBooleanSequenceValue) {
    setRequiredBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( requiredBooleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredBooleanSequenceValue requiredBooleanSequenceValue(
      @Nonnull final Boolean... requiredBooleanSequenceValue) {
    setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
    return this;
  }
}
