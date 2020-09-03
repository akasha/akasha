package com.example;

import elemental2.core.Uint8ClampedArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface Dictionary_requiredNullableUint8ClampedArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUint8ClampedArrayValue create(
      @Nullable final Uint8ClampedArray requiredNullableUint8ClampedArrayValue) {
    return Js.<Dictionary_requiredNullableUint8ClampedArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUint8ClampedArrayValue( requiredNullableUint8ClampedArrayValue );
  }

  @JsProperty(
      name = "requiredNullableUint8ClampedArrayValue"
  )
  @Nullable
  Uint8ClampedArray requiredNullableUint8ClampedArrayValue();

  @JsProperty
  void setRequiredNullableUint8ClampedArrayValue(
      @Nullable Uint8ClampedArray requiredNullableUint8ClampedArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUint8ClampedArrayValue requiredNullableUint8ClampedArrayValue(
      @Nullable final Uint8ClampedArray requiredNullableUint8ClampedArrayValue) {
    setRequiredNullableUint8ClampedArrayValue( requiredNullableUint8ClampedArrayValue );
    return this;
  }
}
