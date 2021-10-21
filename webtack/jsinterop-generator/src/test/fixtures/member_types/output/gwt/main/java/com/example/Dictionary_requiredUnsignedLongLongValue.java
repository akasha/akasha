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
    name = "Object"
)
public interface Dictionary_requiredUnsignedLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedLongLongValue requiredUnsignedLongLongValue(
      final int requiredUnsignedLongLongValue) {
    final Dictionary_requiredUnsignedLongLongValue $dictionaryRequiredUnsignedLongLongValue = Js.<Dictionary_requiredUnsignedLongLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUnsignedLongLongValue.setRequiredUnsignedLongLongValue( requiredUnsignedLongLongValue );
    return Js.uncheckedCast( $dictionaryRequiredUnsignedLongLongValue );
  }

  @JsProperty(
      name = "requiredUnsignedLongLongValue"
  )
  int requiredUnsignedLongLongValue();

  @JsProperty
  void setRequiredUnsignedLongLongValue(int requiredUnsignedLongLongValue);
}
