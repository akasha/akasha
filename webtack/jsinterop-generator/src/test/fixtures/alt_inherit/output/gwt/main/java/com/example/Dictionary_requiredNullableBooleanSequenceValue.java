package com.example;

import com.other.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
  static Builder requiredNullableBooleanSequenceValue(
      @Nullable final JsArray<Boolean> requiredNullableBooleanSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredNullableBooleanSequenceValue(
      @Nullable final Boolean[] requiredNullableBooleanSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanSequenceValue"
  )
  @JsNullable
  JsArray<Boolean> requiredNullableBooleanSequenceValue();

  @JsProperty
  void setRequiredNullableBooleanSequenceValue(
      @JsNullable JsArray<Boolean> requiredNullableBooleanSequenceValue);

  @JsOverlay
  default void setRequiredNullableBooleanSequenceValue(
      @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( requiredNullableBooleanSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableBooleanSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableBooleanSequenceValue(
        @Nullable final JsArray<Boolean> requiredNullableBooleanSequenceValue) {
      setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredNullableBooleanSequenceValue(
        @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
      setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
      return this;
    }
  }
}
