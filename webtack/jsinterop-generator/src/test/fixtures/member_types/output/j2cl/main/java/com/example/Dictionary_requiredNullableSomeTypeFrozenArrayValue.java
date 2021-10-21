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
    name = "Dictionary_requiredNullableSomeTypeFrozenArrayValue"
)
public interface Dictionary_requiredNullableSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeFrozenArrayValue requiredNullableSomeTypeFrozenArrayValue(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue) {
    final Dictionary_requiredNullableSomeTypeFrozenArrayValue $dictionaryRequiredNullableSomeTypeFrozenArrayValue = Js.<Dictionary_requiredNullableSomeTypeFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableSomeTypeFrozenArrayValue.setRequiredNullableSomeTypeFrozenArrayValue( requiredNullableSomeTypeFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeFrozenArrayValue"
  )
  @JsNullable
  JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredNullableSomeTypeFrozenArrayValue(
      @JsNullable JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue);
}
