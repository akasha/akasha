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
    name = "Dictionary_requiredOctetValue"
)
public interface Dictionary_requiredOctetValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredOctetValue requiredOctetValue(final short requiredOctetValue) {
    final Dictionary_requiredOctetValue $dictionaryRequiredOctetValue = Js.<Dictionary_requiredOctetValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredOctetValue.setRequiredOctetValue( requiredOctetValue );
    return Js.uncheckedCast( $dictionaryRequiredOctetValue );
  }

  @JsProperty(
      name = "requiredOctetValue"
  )
  short requiredOctetValue();

  @JsProperty
  void setRequiredOctetValue(short requiredOctetValue);
}
