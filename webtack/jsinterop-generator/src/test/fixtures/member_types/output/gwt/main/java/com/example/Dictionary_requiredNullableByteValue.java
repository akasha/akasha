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
    name = "Object"
)
public interface Dictionary_requiredNullableByteValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableByteValue requiredNullableByteValue(
      @Nullable final Double requiredNullableByteValue) {
    final Dictionary_requiredNullableByteValue $dictionaryRequiredNullableByteValue = Js.<Dictionary_requiredNullableByteValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableByteValue.setRequiredNullableByteValue( requiredNullableByteValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableByteValue );
  }

  @JsProperty(
      name = "requiredNullableByteValue"
  )
  @JsNullable
  Double requiredNullableByteValue();

  @JsProperty
  void setRequiredNullableByteValue(@JsNullable Double requiredNullableByteValue);
}
