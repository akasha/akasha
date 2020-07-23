package com.example;

import elemental2.core.Uint8Array;
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
public interface Dictionary_requiredNullableUint8ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUint8ArrayValue create(
      @Nullable final Uint8Array requiredNullableUint8ArrayValue) {
    return Js.<Dictionary_requiredNullableUint8ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUint8ArrayValue( requiredNullableUint8ArrayValue );
  }

  @JsProperty
  @Nullable
  Uint8Array getRequiredNullableUint8ArrayValue();

  @JsProperty
  void setRequiredNullableUint8ArrayValue(@Nullable Uint8Array requiredNullableUint8ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUint8ArrayValue requiredNullableUint8ArrayValue(
      @Nullable final Uint8Array requiredNullableUint8ArrayValue) {
    setRequiredNullableUint8ArrayValue( requiredNullableUint8ArrayValue );
    return this;
  }
}
