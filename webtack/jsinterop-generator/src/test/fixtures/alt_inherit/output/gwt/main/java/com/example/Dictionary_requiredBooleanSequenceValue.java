package com.example;

import com.other.JsArray;
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
public interface Dictionary_requiredBooleanSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredBooleanSequenceValue(
      @Nonnull final JsArray<Boolean> requiredBooleanSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredBooleanSequenceValue( requiredBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredBooleanSequenceValue(
      @Nonnull final Boolean... requiredBooleanSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredBooleanSequenceValue( requiredBooleanSequenceValue );
  }

  @JsProperty(
      name = "requiredBooleanSequenceValue"
  )
  @JsNonNull
  JsArray<Boolean> requiredBooleanSequenceValue();

  @JsProperty
  void setRequiredBooleanSequenceValue(@JsNonNull JsArray<Boolean> requiredBooleanSequenceValue);

  @JsOverlay
  default void setRequiredBooleanSequenceValue(
      @Nonnull final Boolean... requiredBooleanSequenceValue) {
    setRequiredBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( requiredBooleanSequenceValue ) );
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredBooleanSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredBooleanSequenceValue(
        @Nonnull final JsArray<Boolean> requiredBooleanSequenceValue) {
      setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredBooleanSequenceValue(
        @Nonnull final Boolean... requiredBooleanSequenceValue) {
      setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
      return this;
    }
  }
}
