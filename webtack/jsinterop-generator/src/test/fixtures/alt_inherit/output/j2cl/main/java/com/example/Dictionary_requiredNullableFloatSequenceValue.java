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
    name = "Dictionary_requiredNullableFloatSequenceValue"
)
public interface Dictionary_requiredNullableFloatSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatSequenceValue requiredNullableFloatSequenceValue(
      @Nullable final JsArray<Double> requiredNullableFloatSequenceValue) {
    final Dictionary_requiredNullableFloatSequenceValue $dictionaryRequiredNullableFloatSequenceValue = Js.<Dictionary_requiredNullableFloatSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableFloatSequenceValue.setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableFloatSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatSequenceValue requiredNullableFloatSequenceValue(
      @Nullable final double... requiredNullableFloatSequenceValue) {
    final Dictionary_requiredNullableFloatSequenceValue $dictionaryRequiredNullableFloatSequenceValue = Js.<Dictionary_requiredNullableFloatSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableFloatSequenceValue.setRequiredNullableFloatSequenceValue( requiredNullableFloatSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableFloatSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableFloatSequenceValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableFloatSequenceValue();

  @JsProperty
  void setRequiredNullableFloatSequenceValue(
      @JsNullable JsArray<Double> requiredNullableFloatSequenceValue);

  @JsOverlay
  default void setRequiredNullableFloatSequenceValue(
      @Nullable final double... requiredNullableFloatSequenceValue) {
    setRequiredNullableFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableFloatSequenceValue ) );
  }
}
