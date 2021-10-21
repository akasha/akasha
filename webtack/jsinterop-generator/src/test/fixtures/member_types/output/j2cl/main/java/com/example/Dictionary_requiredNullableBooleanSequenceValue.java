package com.example;

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
    name = "Dictionary_requiredNullableBooleanSequenceValue"
)
public interface Dictionary_requiredNullableBooleanSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanSequenceValue requiredNullableBooleanSequenceValue(
      @Nullable final JsArray<Boolean> requiredNullableBooleanSequenceValue) {
    final Dictionary_requiredNullableBooleanSequenceValue $dictionaryRequiredNullableBooleanSequenceValue = Js.<Dictionary_requiredNullableBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableBooleanSequenceValue.setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableBooleanSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanSequenceValue requiredNullableBooleanSequenceValue(
      @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
    final Dictionary_requiredNullableBooleanSequenceValue $dictionaryRequiredNullableBooleanSequenceValue = Js.<Dictionary_requiredNullableBooleanSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableBooleanSequenceValue.setRequiredNullableBooleanSequenceValue( requiredNullableBooleanSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableBooleanSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanSequenceValue"
  )
  @JsNullable
  JsArray<Boolean> requiredNullableBooleanSequenceValue();

  @JsProperty
  void setRequiredNullableBooleanSequenceValue(
      @JsNullable JsArray<Boolean> requiredNullableBooleanSequenceValue);

  @JsOverlay
  default void setRequiredNullableBooleanSequenceValue(
      @Nullable final Boolean... requiredNullableBooleanSequenceValue) {
    setRequiredNullableBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( requiredNullableBooleanSequenceValue ) );
  }
}
