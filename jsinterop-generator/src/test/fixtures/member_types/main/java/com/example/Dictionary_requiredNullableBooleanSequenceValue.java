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

  @JsProperty
  @Nullable
  JsArray<Boolean> getRequiredNullableBooleanSequenceValue();

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
      @Nullable final Boolean[] requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( JsArray.asJsArray( requiredNullableBooleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableBooleanSequenceValue requiredNullableBooleanSequenceValue(
      @Nullable final Boolean[] requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
    return this;
  }
}
