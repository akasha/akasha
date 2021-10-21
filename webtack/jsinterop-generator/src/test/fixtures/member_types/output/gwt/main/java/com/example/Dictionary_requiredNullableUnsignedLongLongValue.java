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
public interface Dictionary_requiredNullableUnsignedLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnsignedLongLongValue requiredNullableUnsignedLongLongValue(
      @Nullable final Double requiredNullableUnsignedLongLongValue) {
    final Dictionary_requiredNullableUnsignedLongLongValue $dictionaryRequiredNullableUnsignedLongLongValue = Js.<Dictionary_requiredNullableUnsignedLongLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUnsignedLongLongValue.setRequiredNullableUnsignedLongLongValue( requiredNullableUnsignedLongLongValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUnsignedLongLongValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedLongLongValue"
  )
  @JsNullable
  Double requiredNullableUnsignedLongLongValue();

  @JsProperty
  void setRequiredNullableUnsignedLongLongValue(
      @JsNullable Double requiredNullableUnsignedLongLongValue);
}
