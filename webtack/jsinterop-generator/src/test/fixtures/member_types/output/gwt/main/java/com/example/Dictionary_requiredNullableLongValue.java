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
public interface Dictionary_requiredNullableLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableLongValue requiredNullableLongValue(
      @Nullable final Double requiredNullableLongValue) {
    final Dictionary_requiredNullableLongValue $dictionaryRequiredNullableLongValue = Js.<Dictionary_requiredNullableLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableLongValue.setRequiredNullableLongValue( requiredNullableLongValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableLongValue );
  }

  @JsProperty(
      name = "requiredNullableLongValue"
  )
  @JsNullable
  Double requiredNullableLongValue();

  @JsProperty
  void setRequiredNullableLongValue(@JsNullable Double requiredNullableLongValue);
}
