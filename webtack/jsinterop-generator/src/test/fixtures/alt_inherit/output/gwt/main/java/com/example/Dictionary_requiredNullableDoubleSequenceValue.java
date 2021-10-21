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
public interface Dictionary_requiredNullableDoubleSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleSequenceValue requiredNullableDoubleSequenceValue(
      @Nullable final JsArray<Double> requiredNullableDoubleSequenceValue) {
    final Dictionary_requiredNullableDoubleSequenceValue $dictionaryRequiredNullableDoubleSequenceValue = Js.<Dictionary_requiredNullableDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableDoubleSequenceValue.setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableDoubleSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleSequenceValue requiredNullableDoubleSequenceValue(
      @Nullable final double... requiredNullableDoubleSequenceValue) {
    final Dictionary_requiredNullableDoubleSequenceValue $dictionaryRequiredNullableDoubleSequenceValue = Js.<Dictionary_requiredNullableDoubleSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableDoubleSequenceValue.setRequiredNullableDoubleSequenceValue( requiredNullableDoubleSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableDoubleSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleSequenceValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableDoubleSequenceValue();

  @JsProperty
  void setRequiredNullableDoubleSequenceValue(
      @JsNullable JsArray<Double> requiredNullableDoubleSequenceValue);

  @JsOverlay
  default void setRequiredNullableDoubleSequenceValue(
      @Nullable final double... requiredNullableDoubleSequenceValue) {
    setRequiredNullableDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableDoubleSequenceValue ) );
  }
}
