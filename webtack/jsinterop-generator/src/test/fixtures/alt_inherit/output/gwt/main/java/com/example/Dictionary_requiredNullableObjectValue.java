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
public interface Dictionary_requiredNullableObjectValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableObjectValue requiredNullableObjectValue(
      @Nullable final JsObject requiredNullableObjectValue) {
    final Dictionary_requiredNullableObjectValue $dictionaryRequiredNullableObjectValue = Js.<Dictionary_requiredNullableObjectValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableObjectValue.setRequiredNullableObjectValue( requiredNullableObjectValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableObjectValue );
  }

  @JsProperty(
      name = "requiredNullableObjectValue"
  )
  @JsNullable
  JsObject requiredNullableObjectValue();

  @JsProperty
  void setRequiredNullableObjectValue(@JsNullable JsObject requiredNullableObjectValue);
}
