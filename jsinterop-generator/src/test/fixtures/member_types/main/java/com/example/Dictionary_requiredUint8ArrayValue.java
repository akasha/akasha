package com.example;

import elemental2.core.Uint8Array;
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
public interface Dictionary_requiredUint8ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUint8ArrayValue create(
      @Nonnull final Uint8Array requiredUint8ArrayValue) {
    return Js.<Dictionary_requiredUint8ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredUint8ArrayValue( requiredUint8ArrayValue );
  }

  @JsProperty
  @Nonnull
  Uint8Array getRequiredUint8ArrayValue();

  @JsProperty
  void setRequiredUint8ArrayValue(@Nonnull Uint8Array requiredUint8ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUint8ArrayValue requiredUint8ArrayValue(
      @Nonnull final Uint8Array requiredUint8ArrayValue) {
    setRequiredUint8ArrayValue( requiredUint8ArrayValue );
    return this;
  }
}
