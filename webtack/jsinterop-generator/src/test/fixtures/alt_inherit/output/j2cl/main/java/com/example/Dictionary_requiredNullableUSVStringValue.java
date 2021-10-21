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
    name = "Dictionary_requiredNullableUSVStringValue"
)
public interface Dictionary_requiredNullableUSVStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUSVStringValue requiredNullableUSVStringValue(
      @Nullable final String requiredNullableUSVStringValue) {
    final Dictionary_requiredNullableUSVStringValue $dictionaryRequiredNullableUSVStringValue = Js.<Dictionary_requiredNullableUSVStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUSVStringValue.setRequiredNullableUSVStringValue( requiredNullableUSVStringValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUSVStringValue );
  }

  @JsProperty(
      name = "requiredNullableUSVStringValue"
  )
  @JsNullable
  String requiredNullableUSVStringValue();

  @JsProperty
  void setRequiredNullableUSVStringValue(@JsNullable String requiredNullableUSVStringValue);
}
