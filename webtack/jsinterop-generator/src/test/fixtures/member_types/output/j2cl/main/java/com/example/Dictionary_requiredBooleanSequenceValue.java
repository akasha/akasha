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
    name = "Dictionary_requiredBooleanSequenceValue"
)
public interface Dictionary_requiredBooleanSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanSequenceValue requiredBooleanSequenceValue(
      @Nonnull final JsArray<Boolean> requiredBooleanSequenceValue) {
    final Dictionary_requiredBooleanSequenceValue $dictionaryRequiredBooleanSequenceValue = Js.<Dictionary_requiredBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredBooleanSequenceValue.setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanSequenceValue requiredBooleanSequenceValue(
      @Nonnull final Boolean... requiredBooleanSequenceValue) {
    final Dictionary_requiredBooleanSequenceValue $dictionaryRequiredBooleanSequenceValue = Js.<Dictionary_requiredBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredBooleanSequenceValue.setRequiredBooleanSequenceValue( requiredBooleanSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredBooleanSequenceValue );
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
}
