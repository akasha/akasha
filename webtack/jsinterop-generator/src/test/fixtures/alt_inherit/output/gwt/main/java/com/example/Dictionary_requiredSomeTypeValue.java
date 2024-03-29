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
public interface Dictionary_requiredSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeValue requiredSomeTypeValue(
      @Nonnull final SomeType requiredSomeTypeValue) {
    final Dictionary_requiredSomeTypeValue $dictionaryRequiredSomeTypeValue = Js.<Dictionary_requiredSomeTypeValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredSomeTypeValue.setRequiredSomeTypeValue( requiredSomeTypeValue );
    return Js.uncheckedCast( $dictionaryRequiredSomeTypeValue );
  }

  @JsProperty(
      name = "requiredSomeTypeValue"
  )
  @JsNonNull
  SomeType requiredSomeTypeValue();

  @JsProperty
  void setRequiredSomeTypeValue(@JsNonNull SomeType requiredSomeTypeValue);
}
