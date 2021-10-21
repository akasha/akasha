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
    name = "Dictionary_requiredNullableUnsignedShortValue"
)
public interface Dictionary_requiredNullableUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnsignedShortValue requiredNullableUnsignedShortValue(
      @Nullable final Double requiredNullableUnsignedShortValue) {
    final Dictionary_requiredNullableUnsignedShortValue $dictionaryRequiredNullableUnsignedShortValue = Js.<Dictionary_requiredNullableUnsignedShortValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUnsignedShortValue.setRequiredNullableUnsignedShortValue( requiredNullableUnsignedShortValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedShortValue"
  )
  @JsNullable
  Double requiredNullableUnsignedShortValue();

  @JsProperty
  void setRequiredNullableUnsignedShortValue(@JsNullable Double requiredNullableUnsignedShortValue);
}
