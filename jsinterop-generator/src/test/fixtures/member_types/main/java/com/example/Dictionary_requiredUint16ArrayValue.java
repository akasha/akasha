package com.example;

import elemental2.core.Uint16Array;
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
public interface Dictionary_requiredUint16ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUint16ArrayValue create(
      @Nonnull final Uint16Array requiredUint16ArrayValue) {
    return Js.<Dictionary_requiredUint16ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredUint16ArrayValue( requiredUint16ArrayValue );
  }

  @JsProperty
  @Nonnull
  Uint16Array getRequiredUint16ArrayValue();

  @JsProperty
  void setRequiredUint16ArrayValue(@Nonnull Uint16Array requiredUint16ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUint16ArrayValue requiredUint16ArrayValue(
      @Nonnull final Uint16Array requiredUint16ArrayValue) {
    setRequiredUint16ArrayValue( requiredUint16ArrayValue );
    return this;
  }
}
