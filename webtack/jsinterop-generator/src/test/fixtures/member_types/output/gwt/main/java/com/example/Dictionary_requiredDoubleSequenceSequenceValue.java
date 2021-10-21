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
public interface Dictionary_requiredDoubleSequenceSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleSequenceSequenceValue requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue) {
    final Dictionary_requiredDoubleSequenceSequenceValue $dictionaryRequiredDoubleSequenceSequenceValue = Js.<Dictionary_requiredDoubleSequenceSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleSequenceSequenceValue.setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleSequenceSequenceValue );
  }

  @JsOverlay
  @Nonnull
  @SuppressWarnings("unchecked")
  static Dictionary_requiredDoubleSequenceSequenceValue requiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    final Dictionary_requiredDoubleSequenceSequenceValue $dictionaryRequiredDoubleSequenceSequenceValue = Js.<Dictionary_requiredDoubleSequenceSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleSequenceSequenceValue.setRequiredDoubleSequenceSequenceValue( requiredDoubleSequenceSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleSequenceSequenceValue );
  }

  @JsProperty(
      name = "requiredDoubleSequenceSequenceValue"
  )
  @JsNonNull
  JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue();

  @JsProperty
  void setRequiredDoubleSequenceSequenceValue(
      @JsNonNull JsArray<JsArray<Double>> requiredDoubleSequenceSequenceValue);

  @JsOverlay
  @SuppressWarnings("unchecked")
  default void setRequiredDoubleSequenceSequenceValue(
      @Nonnull final JsArray<Double>... requiredDoubleSequenceSequenceValue) {
    setRequiredDoubleSequenceSequenceValue( Js.<JsArray<JsArray<Double>>>uncheckedCast( requiredDoubleSequenceSequenceValue ) );
  }
}
