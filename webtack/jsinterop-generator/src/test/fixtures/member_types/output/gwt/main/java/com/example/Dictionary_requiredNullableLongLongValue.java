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
public interface Dictionary_requiredNullableLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableLongLongValue requiredNullableLongLongValue(
      @Nullable final Double requiredNullableLongLongValue) {
    final Dictionary_requiredNullableLongLongValue $dictionaryRequiredNullableLongLongValue = Js.<Dictionary_requiredNullableLongLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableLongLongValue.setRequiredNullableLongLongValue( requiredNullableLongLongValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableLongLongValue );
  }

  @JsProperty(
      name = "requiredNullableLongLongValue"
  )
  @JsNullable
  Double requiredNullableLongLongValue();

  @JsProperty
  void setRequiredNullableLongLongValue(@JsNullable Double requiredNullableLongLongValue);
}
