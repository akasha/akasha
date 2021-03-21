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
public interface Dictionary_requiredShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortValue create(final short requiredShortValue) {
    return Js.<Dictionary_requiredShortValue>uncheckedCast( JsPropertyMap.of() ).requiredShortValue( requiredShortValue );
  }

  @JsProperty(
      name = "requiredShortValue"
  )
  short requiredShortValue();

  @JsProperty
  void setRequiredShortValue(short requiredShortValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredShortValue requiredShortValue(final short requiredShortValue) {
    setRequiredShortValue( requiredShortValue );
    return this;
  }
}
