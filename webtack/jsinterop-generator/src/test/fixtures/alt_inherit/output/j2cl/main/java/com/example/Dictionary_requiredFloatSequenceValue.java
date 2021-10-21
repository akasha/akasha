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
    name = "Dictionary_requiredFloatSequenceValue"
)
public interface Dictionary_requiredFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatSequenceValue requiredFloatSequenceValue(
      @Nonnull final JsArray<Double> requiredFloatSequenceValue) {
    final Dictionary_requiredFloatSequenceValue $dictionaryRequiredFloatSequenceValue = Js.<Dictionary_requiredFloatSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredFloatSequenceValue.setRequiredFloatSequenceValue( requiredFloatSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatSequenceValue requiredFloatSequenceValue(
      @Nonnull final double... requiredFloatSequenceValue) {
    final Dictionary_requiredFloatSequenceValue $dictionaryRequiredFloatSequenceValue = Js.<Dictionary_requiredFloatSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredFloatSequenceValue.setRequiredFloatSequenceValue( requiredFloatSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredFloatSequenceValue"
  )
  @JsNonNull
  JsArray<Double> requiredFloatSequenceValue();

  @JsProperty
  void setRequiredFloatSequenceValue(@JsNonNull JsArray<Double> requiredFloatSequenceValue);

  @JsOverlay
  default void setRequiredFloatSequenceValue(@Nonnull final double... requiredFloatSequenceValue) {
    setRequiredFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredFloatSequenceValue ) );
  }
}
