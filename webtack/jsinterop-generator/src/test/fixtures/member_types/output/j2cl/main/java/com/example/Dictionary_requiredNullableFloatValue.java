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
    name = "Dictionary_requiredNullableFloatValue"
)
public interface Dictionary_requiredNullableFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatValue requiredNullableFloatValue(
      @Nullable final Double requiredNullableFloatValue) {
    final Dictionary_requiredNullableFloatValue $dictionaryRequiredNullableFloatValue = Js.<Dictionary_requiredNullableFloatValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableFloatValue.setRequiredNullableFloatValue( requiredNullableFloatValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableFloatValue );
  }

  @JsProperty(
      name = "requiredNullableFloatValue"
  )
  @JsNullable
  Double requiredNullableFloatValue();

  @JsProperty
  void setRequiredNullableFloatValue(@JsNullable Double requiredNullableFloatValue);
}
