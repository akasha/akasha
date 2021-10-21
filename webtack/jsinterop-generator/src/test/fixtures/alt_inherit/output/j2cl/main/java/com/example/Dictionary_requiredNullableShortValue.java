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
    name = "Dictionary_requiredNullableShortValue"
)
public interface Dictionary_requiredNullableShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortValue requiredNullableShortValue(
      @Nullable final Double requiredNullableShortValue) {
    final Dictionary_requiredNullableShortValue $dictionaryRequiredNullableShortValue = Js.<Dictionary_requiredNullableShortValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableShortValue.setRequiredNullableShortValue( requiredNullableShortValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableShortValue );
  }

  @JsProperty(
      name = "requiredNullableShortValue"
  )
  @JsNullable
  Double requiredNullableShortValue();

  @JsProperty
  void setRequiredNullableShortValue(@JsNullable Double requiredNullableShortValue);
}
