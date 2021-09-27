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
public interface Dictionary_requiredSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredSomeTypeSequenceValue(
      @Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsProperty(
      name = "requiredSomeTypeSequenceValue"
  )
  @JsNonNull
  JsArray<SomeType> requiredSomeTypeSequenceValue();

  @JsProperty
  void setRequiredSomeTypeSequenceValue(@JsNonNull JsArray<SomeType> requiredSomeTypeSequenceValue);

  @JsOverlay
  default void setRequiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( requiredSomeTypeSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredSomeTypeSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredSomeTypeSequenceValue(
        @Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
      setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredSomeTypeSequenceValue(
        @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
      setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
      return this;
    }
  }
}
