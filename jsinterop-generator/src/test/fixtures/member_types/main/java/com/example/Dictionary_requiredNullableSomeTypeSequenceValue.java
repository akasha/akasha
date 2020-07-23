package com.example;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface Dictionary_requiredNullableSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeSequenceValue create(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeSequenceValue) {
    return Js.<Dictionary_requiredNullableSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeSequenceValue create(
      @Nullable final SomeType[] requiredNullableSomeTypeSequenceValue) {
    return Js.<Dictionary_requiredNullableSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
  }

  @JsProperty
  @Nullable
  JsArray<SomeType> getRequiredNullableSomeTypeSequenceValue();

  @JsProperty
  void setRequiredNullableSomeTypeSequenceValue(
      @Nullable JsArray<SomeType> requiredNullableSomeTypeSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSomeTypeSequenceValue requiredNullableSomeTypeSequenceValue(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredNullableSomeTypeSequenceValue(
      @Nullable final SomeType[] requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( JsArray.asJsArray( requiredNullableSomeTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSomeTypeSequenceValue requiredNullableSomeTypeSequenceValue(
      @Nullable final SomeType[] requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
    return this;
  }
}
