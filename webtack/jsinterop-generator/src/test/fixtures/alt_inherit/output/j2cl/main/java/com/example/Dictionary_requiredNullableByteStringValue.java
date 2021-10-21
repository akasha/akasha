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
    name = "Dictionary_requiredNullableByteStringValue"
)
public interface Dictionary_requiredNullableByteStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableByteStringValue requiredNullableByteStringValue(
      @Nullable final String requiredNullableByteStringValue) {
    final Dictionary_requiredNullableByteStringValue $dictionaryRequiredNullableByteStringValue = Js.<Dictionary_requiredNullableByteStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableByteStringValue.setRequiredNullableByteStringValue( requiredNullableByteStringValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableByteStringValue );
  }

  @JsProperty(
      name = "requiredNullableByteStringValue"
  )
  @JsNullable
  String requiredNullableByteStringValue();

  @JsProperty
  void setRequiredNullableByteStringValue(@JsNullable String requiredNullableByteStringValue);
}
