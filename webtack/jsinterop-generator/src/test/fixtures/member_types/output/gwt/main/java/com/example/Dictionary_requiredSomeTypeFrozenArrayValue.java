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
public interface Dictionary_requiredSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeFrozenArrayValue requiredSomeTypeFrozenArrayValue(
      @Nonnull final JsArray<SomeType> requiredSomeTypeFrozenArrayValue) {
    final Dictionary_requiredSomeTypeFrozenArrayValue $dictionaryRequiredSomeTypeFrozenArrayValue = Js.<Dictionary_requiredSomeTypeFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredSomeTypeFrozenArrayValue.setRequiredSomeTypeFrozenArrayValue( requiredSomeTypeFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredSomeTypeFrozenArrayValue"
  )
  @JsNonNull
  JsArray<SomeType> requiredSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredSomeTypeFrozenArrayValue(
      @JsNonNull JsArray<SomeType> requiredSomeTypeFrozenArrayValue);
}
