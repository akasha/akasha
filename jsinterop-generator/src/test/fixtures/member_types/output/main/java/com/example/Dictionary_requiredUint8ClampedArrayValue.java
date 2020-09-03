package com.example;

import elemental2.core.Uint8ClampedArray;
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
public interface Dictionary_requiredUint8ClampedArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUint8ClampedArrayValue create(
      @Nonnull final Uint8ClampedArray requiredUint8ClampedArrayValue) {
    return Js.<Dictionary_requiredUint8ClampedArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredUint8ClampedArrayValue( requiredUint8ClampedArrayValue );
  }

  @JsProperty(
      name = "requiredUint8ClampedArrayValue"
  )
  @Nonnull
  Uint8ClampedArray requiredUint8ClampedArrayValue();

  @JsProperty
  void setRequiredUint8ClampedArrayValue(@Nonnull Uint8ClampedArray requiredUint8ClampedArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUint8ClampedArrayValue requiredUint8ClampedArrayValue(
      @Nonnull final Uint8ClampedArray requiredUint8ClampedArrayValue) {
    setRequiredUint8ClampedArrayValue( requiredUint8ClampedArrayValue );
    return this;
  }
}
