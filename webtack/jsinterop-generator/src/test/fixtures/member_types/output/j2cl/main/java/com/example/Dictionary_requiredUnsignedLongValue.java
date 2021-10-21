package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
    name = "Dictionary_requiredUnsignedLongValue"
)
public interface Dictionary_requiredUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedLongValue requiredUnsignedLongValue(
      final int requiredUnsignedLongValue) {
    final Dictionary_requiredUnsignedLongValue $dictionaryRequiredUnsignedLongValue = Js.<Dictionary_requiredUnsignedLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUnsignedLongValue.setRequiredUnsignedLongValue( requiredUnsignedLongValue );
    return Js.uncheckedCast( $dictionaryRequiredUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredUnsignedLongValue"
  )
  int requiredUnsignedLongValue();

  @JsProperty
  void setRequiredUnsignedLongValue(int requiredUnsignedLongValue);
}
