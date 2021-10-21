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
    name = "Dictionary_requiredNullableOctetValue"
)
public interface Dictionary_requiredNullableOctetValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableOctetValue requiredNullableOctetValue(
      @Nullable final Double requiredNullableOctetValue) {
    final Dictionary_requiredNullableOctetValue $dictionaryRequiredNullableOctetValue = Js.<Dictionary_requiredNullableOctetValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableOctetValue.setRequiredNullableOctetValue( requiredNullableOctetValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableOctetValue );
  }

  @JsProperty(
      name = "requiredNullableOctetValue"
  )
  @JsNullable
  Double requiredNullableOctetValue();

  @JsProperty
  void setRequiredNullableOctetValue(@JsNullable Double requiredNullableOctetValue);
}
