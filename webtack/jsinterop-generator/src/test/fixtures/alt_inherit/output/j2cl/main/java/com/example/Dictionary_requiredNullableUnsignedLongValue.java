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
    name = "Dictionary_requiredNullableUnsignedLongValue"
)
public interface Dictionary_requiredNullableUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnsignedLongValue requiredNullableUnsignedLongValue(
      @Nullable final Double requiredNullableUnsignedLongValue) {
    final Dictionary_requiredNullableUnsignedLongValue $dictionaryRequiredNullableUnsignedLongValue = Js.<Dictionary_requiredNullableUnsignedLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUnsignedLongValue.setRequiredNullableUnsignedLongValue( requiredNullableUnsignedLongValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedLongValue"
  )
  @JsNullable
  Double requiredNullableUnsignedLongValue();

  @JsProperty
  void setRequiredNullableUnsignedLongValue(@JsNullable Double requiredNullableUnsignedLongValue);
}
