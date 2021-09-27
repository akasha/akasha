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
public interface Dictionary_requiredDoubleSequenceValue {
  @JsOverlay
  @Nonnull
  static Builder requiredDoubleSequenceValue(
      @Nonnull final JsArray<Double> requiredDoubleSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceValue( requiredDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder requiredDoubleSequenceValue(@Nonnull final double... requiredDoubleSequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleSequenceValue( requiredDoubleSequenceValue );
  }

  @JsProperty(
      name = "requiredDoubleSequenceValue"
  )
  @JsNonNull
  JsArray<Double> requiredDoubleSequenceValue();

  @JsProperty
  void setRequiredDoubleSequenceValue(@JsNonNull JsArray<Double> requiredDoubleSequenceValue);

  @JsOverlay
  default void setRequiredDoubleSequenceValue(
      @Nonnull final double... requiredDoubleSequenceValue) {
    setRequiredDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredDoubleSequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredDoubleSequenceValue {
    @JsOverlay
    @Nonnull
    default Builder requiredDoubleSequenceValue(
        @Nonnull final JsArray<Double> requiredDoubleSequenceValue) {
      setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredDoubleSequenceValue(
        @Nonnull final double... requiredDoubleSequenceValue) {
      setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
      return this;
    }
  }
}
