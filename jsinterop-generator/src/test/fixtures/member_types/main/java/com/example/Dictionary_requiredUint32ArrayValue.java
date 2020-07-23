package com.example;

import elemental2.core.Uint32Array;
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
public interface Dictionary_requiredUint32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUint32ArrayValue create(
      @Nonnull final Uint32Array requiredUint32ArrayValue) {
    return Js.<Dictionary_requiredUint32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredUint32ArrayValue( requiredUint32ArrayValue );
  }

  @JsProperty
  @Nonnull
  Uint32Array getRequiredUint32ArrayValue();

  @JsProperty
  void setRequiredUint32ArrayValue(@Nonnull Uint32Array requiredUint32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUint32ArrayValue requiredUint32ArrayValue(
      @Nonnull final Uint32Array requiredUint32ArrayValue) {
    setRequiredUint32ArrayValue( requiredUint32ArrayValue );
    return this;
  }
}
