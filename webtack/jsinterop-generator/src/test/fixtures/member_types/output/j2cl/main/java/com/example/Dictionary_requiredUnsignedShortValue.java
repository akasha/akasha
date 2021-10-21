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
    name = "Dictionary_requiredUnsignedShortValue"
)
public interface Dictionary_requiredUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedShortValue requiredUnsignedShortValue(
      final int requiredUnsignedShortValue) {
    final Dictionary_requiredUnsignedShortValue $dictionaryRequiredUnsignedShortValue = Js.<Dictionary_requiredUnsignedShortValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUnsignedShortValue.setRequiredUnsignedShortValue( requiredUnsignedShortValue );
    return Js.uncheckedCast( $dictionaryRequiredUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredUnsignedShortValue"
  )
  int requiredUnsignedShortValue();

  @JsProperty
  void setRequiredUnsignedShortValue(int requiredUnsignedShortValue);
}
