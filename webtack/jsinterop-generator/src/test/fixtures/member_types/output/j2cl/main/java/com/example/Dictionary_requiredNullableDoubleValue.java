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
    name = "Dictionary_requiredNullableDoubleValue"
)
public interface Dictionary_requiredNullableDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleValue requiredNullableDoubleValue(
      @Nullable final Double requiredNullableDoubleValue) {
    final Dictionary_requiredNullableDoubleValue $dictionaryRequiredNullableDoubleValue = Js.<Dictionary_requiredNullableDoubleValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableDoubleValue.setRequiredNullableDoubleValue( requiredNullableDoubleValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleValue"
  )
  @JsNullable
  Double requiredNullableDoubleValue();

  @JsProperty
  void setRequiredNullableDoubleValue(@JsNullable Double requiredNullableDoubleValue);
}
