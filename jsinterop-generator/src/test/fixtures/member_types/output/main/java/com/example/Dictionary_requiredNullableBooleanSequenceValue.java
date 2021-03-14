package com.example;

import akasha.lang.JsArray;
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
public interface Dictionary_requiredNullableBooleanSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanSequenceValue create(
      @Nullable final JsArray<Boolean> requiredNullableBooleanSequenceValue) {
    return Js.<Dictionary_requiredNullableBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanSequenceValue create(
      @Nullable final Boolean[] requiredNullableBooleanSequenceValue) {
    return Js.<Dictionary_requiredNullableBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanSequenceValue"
  )
  @Nullable
  JsArray<Boolean> requiredNullableBooleanSequenceValue();

  @JsProperty
  void setRequiredNullableBooleanSequenceValue(
      @Nullable JsArray<Boolean> requiredNullableBooleanSequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableBooleanSequenceValue requiredNullableBooleanSequenceValue(
      @Nullable final JsArray<Boolean> requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredNullableBooleanSequenceValue(
      @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( requiredNullableBooleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableBooleanSequenceValue requiredNullableBooleanSequenceValue(
      @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
    return this;
  }
}
