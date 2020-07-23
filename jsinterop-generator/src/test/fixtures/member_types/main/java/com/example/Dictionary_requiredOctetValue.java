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
    name = "?"
)
public interface Dictionary_requiredOctetValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredOctetValue create(final short requiredOctetValue) {
    return Js.<Dictionary_requiredOctetValue>uncheckedCast( JsPropertyMap.of() ).requiredOctetValue( requiredOctetValue );
  }

  @JsProperty
  short getRequiredOctetValue();

  @JsProperty
  void setRequiredOctetValue(short requiredOctetValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredOctetValue requiredOctetValue(final short requiredOctetValue) {
    setRequiredOctetValue( requiredOctetValue );
    return this;
  }
}
