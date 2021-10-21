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
    name = "Dictionary_requiredShortSequenceValue"
)
public interface Dictionary_requiredShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortSequenceValue requiredShortSequenceValue(
      @Nonnull final JsArray<Double> requiredShortSequenceValue) {
    final Dictionary_requiredShortSequenceValue $dictionaryRequiredShortSequenceValue = Js.<Dictionary_requiredShortSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredShortSequenceValue.setRequiredShortSequenceValue( requiredShortSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortSequenceValue requiredShortSequenceValue(
      @Nonnull final double... requiredShortSequenceValue) {
    final Dictionary_requiredShortSequenceValue $dictionaryRequiredShortSequenceValue = Js.<Dictionary_requiredShortSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredShortSequenceValue.setRequiredShortSequenceValue( requiredShortSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredShortSequenceValue );
  }

  @JsProperty(
      name = "requiredShortSequenceValue"
  )
  @JsNonNull
  JsArray<Double> requiredShortSequenceValue();

  @JsProperty
  void setRequiredShortSequenceValue(@JsNonNull JsArray<Double> requiredShortSequenceValue);

  @JsOverlay
  default void setRequiredShortSequenceValue(@Nonnull final double... requiredShortSequenceValue) {
    setRequiredShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredShortSequenceValue ) );
  }
}
