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
    name = "Object"
)
public interface Dictionary_requiredShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortValue requiredShortValue(final short requiredShortValue) {
    final Dictionary_requiredShortValue $dictionaryRequiredShortValue = Js.<Dictionary_requiredShortValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredShortValue.setRequiredShortValue( requiredShortValue );
    return Js.uncheckedCast( $dictionaryRequiredShortValue );
  }

  @JsProperty(
      name = "requiredShortValue"
  )
  short requiredShortValue();

  @JsProperty
  void setRequiredShortValue(short requiredShortValue);
}
