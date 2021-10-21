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
    name = "Dictionary_requiredNullableShortSequenceValue"
)
public interface Dictionary_requiredNullableShortSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortSequenceValue requiredNullableShortSequenceValue(
      @Nullable final JsArray<Double> requiredNullableShortSequenceValue) {
    final Dictionary_requiredNullableShortSequenceValue $dictionaryRequiredNullableShortSequenceValue = Js.<Dictionary_requiredNullableShortSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableShortSequenceValue.setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableShortSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortSequenceValue requiredNullableShortSequenceValue(
      @Nullable final double... requiredNullableShortSequenceValue) {
    final Dictionary_requiredNullableShortSequenceValue $dictionaryRequiredNullableShortSequenceValue = Js.<Dictionary_requiredNullableShortSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableShortSequenceValue.setRequiredNullableShortSequenceValue( requiredNullableShortSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableShortSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableShortSequenceValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableShortSequenceValue();

  @JsProperty
  void setRequiredNullableShortSequenceValue(
      @JsNullable JsArray<Double> requiredNullableShortSequenceValue);

  @JsOverlay
  default void setRequiredNullableShortSequenceValue(
      @Nullable final double... requiredNullableShortSequenceValue) {
    setRequiredNullableShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( requiredNullableShortSequenceValue ) );
  }
}
