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
    name = "Dictionary_requiredNullableSomeTypeValue"
)
public interface Dictionary_requiredNullableSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeValue requiredNullableSomeTypeValue(
      @Nullable final SomeType requiredNullableSomeTypeValue) {
    final Dictionary_requiredNullableSomeTypeValue $dictionaryRequiredNullableSomeTypeValue = Js.<Dictionary_requiredNullableSomeTypeValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableSomeTypeValue.setRequiredNullableSomeTypeValue( requiredNullableSomeTypeValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableSomeTypeValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeValue"
  )
  @JsNullable
  SomeType requiredNullableSomeTypeValue();

  @JsProperty
  void setRequiredNullableSomeTypeValue(@JsNullable SomeType requiredNullableSomeTypeValue);
}
