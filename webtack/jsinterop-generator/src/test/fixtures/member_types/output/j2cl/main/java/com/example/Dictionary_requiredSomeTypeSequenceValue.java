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
    name = "Dictionary_requiredSomeTypeSequenceValue"
)
public interface Dictionary_requiredSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final SomeType[] requiredSomeTypeSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
  }

  @JsProperty(
      name = "requiredSomeTypeSequenceValue"
  )
  @Nonnull
  JsArray<SomeType> requiredSomeTypeSequenceValue();

  @JsProperty
  void setRequiredSomeTypeSequenceValue(@Nonnull JsArray<SomeType> requiredSomeTypeSequenceValue);

  @JsOverlay
  default void setRequiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( requiredSomeTypeSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredSomeTypeSequenceValue"
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
