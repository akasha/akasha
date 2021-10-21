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
public interface Dictionary_requiredSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeSequenceValue requiredSomeTypeSequenceValue(
      @Nonnull final JsArray<SomeType> requiredSomeTypeSequenceValue) {
    final Dictionary_requiredSomeTypeSequenceValue $dictionaryRequiredSomeTypeSequenceValue = Js.<Dictionary_requiredSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredSomeTypeSequenceValue.setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeSequenceValue requiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    final Dictionary_requiredSomeTypeSequenceValue $dictionaryRequiredSomeTypeSequenceValue = Js.<Dictionary_requiredSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredSomeTypeSequenceValue.setRequiredSomeTypeSequenceValue( requiredSomeTypeSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredSomeTypeSequenceValue );
  }

  @JsProperty(
      name = "requiredSomeTypeSequenceValue"
  )
  @JsNonNull
  JsArray<SomeType> requiredSomeTypeSequenceValue();

  @JsProperty
  void setRequiredSomeTypeSequenceValue(@JsNonNull JsArray<SomeType> requiredSomeTypeSequenceValue);

  @JsOverlay
  default void setRequiredSomeTypeSequenceValue(
      @Nonnull final SomeType... requiredSomeTypeSequenceValue) {
    setRequiredSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( requiredSomeTypeSequenceValue ) );
  }
}
