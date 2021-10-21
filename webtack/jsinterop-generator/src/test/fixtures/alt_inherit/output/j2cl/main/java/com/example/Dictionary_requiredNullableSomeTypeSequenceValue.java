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
    name = "Dictionary_requiredNullableSomeTypeSequenceValue"
)
public interface Dictionary_requiredNullableSomeTypeSequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeSequenceValue requiredNullableSomeTypeSequenceValue(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeSequenceValue) {
    final Dictionary_requiredNullableSomeTypeSequenceValue $dictionaryRequiredNullableSomeTypeSequenceValue = Js.<Dictionary_requiredNullableSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableSomeTypeSequenceValue.setRequiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableSomeTypeSequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeSequenceValue requiredNullableSomeTypeSequenceValue(
      @Nullable final SomeType... requiredNullableSomeTypeSequenceValue) {
    final Dictionary_requiredNullableSomeTypeSequenceValue $dictionaryRequiredNullableSomeTypeSequenceValue = Js.<Dictionary_requiredNullableSomeTypeSequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableSomeTypeSequenceValue.setRequiredNullableSomeTypeSequenceValue( requiredNullableSomeTypeSequenceValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableSomeTypeSequenceValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeSequenceValue"
  )
  @JsNullable
  JsArray<SomeType> requiredNullableSomeTypeSequenceValue();

  @JsProperty
  void setRequiredNullableSomeTypeSequenceValue(
      @JsNullable JsArray<SomeType> requiredNullableSomeTypeSequenceValue);

  @JsOverlay
  default void setRequiredNullableSomeTypeSequenceValue(
      @Nullable final SomeType... requiredNullableSomeTypeSequenceValue) {
    setRequiredNullableSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( requiredNullableSomeTypeSequenceValue ) );
  }
}
