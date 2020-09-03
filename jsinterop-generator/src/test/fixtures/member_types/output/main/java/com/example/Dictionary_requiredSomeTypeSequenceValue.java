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
public interface Dictionary_requiredSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeSequenceValue create(
      @Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
    return Js.<Dictionary_requiredSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeSequenceValue create(
      @Nonnull final SomeType[] requiredSomeTypeSequenceValue) {
    return Js.<Dictionary_requiredSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsProperty(
      name = "requiredSomeTypeSequenceValue"
  )
  @Nonnull
  JsArray<SomeType> requiredSomeTypeSequenceValue();

  @JsProperty
  void setRequiredSomeTypeSequenceValue(@Nonnull JsArray<SomeType> requiredSomeTypeSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredSomeTypeSequenceValue requiredSomeTypeSequenceValue(
      @Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( JsArray.asJsArray( requiredSomeTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredSomeTypeSequenceValue requiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
    return this;
  }
}
