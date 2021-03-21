package com.example;

import com.other.JsArray;
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
    name = "Object"
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

  @JsProperty(
      name = "requiredNullableSomeTypeSequenceValue"
  )
  @Nullable
  JsArray<SomeType> requiredNullableSomeTypeSequenceValue();

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
      @Nullable final SomeType... requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( requiredNullableSomeTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSomeTypeSequenceValue requiredNullableSomeTypeSequenceValue(
      @Nullable final SomeType... requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
    return this;
  }
}
