package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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
    name = "Dictionary_requiredByteValue"
)
public interface Dictionary_requiredByteValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredByteValue requiredByteValue(final byte requiredByteValue) {
    final Dictionary_requiredByteValue $dictionaryRequiredByteValue = Js.<Dictionary_requiredByteValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredByteValue.setRequiredByteValue( requiredByteValue );
    return Js.uncheckedCast( $dictionaryRequiredByteValue );
  }

  @JsProperty(
      name = "requiredByteValue"
  )
  byte requiredByteValue();

  @JsProperty
  void setRequiredByteValue(byte requiredByteValue);
}
