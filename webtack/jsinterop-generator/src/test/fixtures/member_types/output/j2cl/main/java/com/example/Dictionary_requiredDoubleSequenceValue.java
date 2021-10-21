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
    name = "Dictionary_requiredDoubleSequenceValue"
)
public interface Dictionary_requiredDoubleSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceValue requiredDoubleSequenceValue(
      @Nonnull final JsArray<Double> requiredDoubleSequenceValue) {
    final Dictionary_requiredDoubleSequenceValue $dictionaryRequiredDoubleSequenceValue = Js.<Dictionary_requiredDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleSequenceValue.setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceValue requiredDoubleSequenceValue(
      @Nonnull final double... requiredDoubleSequenceValue) {
    final Dictionary_requiredDoubleSequenceValue $dictionaryRequiredDoubleSequenceValue = Js.<Dictionary_requiredDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleSequenceValue.setRequiredDoubleSequenceValue( requiredDoubleSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleSequenceValue );
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
}
