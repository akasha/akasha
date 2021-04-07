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
public interface Dictionary_requiredByteValue {
  @JsOverlay
  @Nonnull
  static Builder create(final byte requiredByteValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredByteValue( requiredByteValue );
  }

  @JsProperty(
      name = "requiredByteValue"
  )
  byte requiredByteValue();

  @JsProperty
  void setRequiredByteValue(byte requiredByteValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredByteValue {
    @JsOverlay
    @Nonnull
    default Builder requiredByteValue(final byte requiredByteValue) {
      setRequiredByteValue( requiredByteValue );
      return this;
    }
  }
}
