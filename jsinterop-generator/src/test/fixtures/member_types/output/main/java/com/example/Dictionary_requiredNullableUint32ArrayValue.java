package com.example;

import elemental2.core.Uint32Array;
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
public interface Dictionary_requiredNullableUint32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUint32ArrayValue create(
      @Nullable final Uint32Array requiredNullableUint32ArrayValue) {
    return Js.<Dictionary_requiredNullableUint32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUint32ArrayValue( requiredNullableUint32ArrayValue );
  }

  @JsProperty(
      name = "requiredNullableUint32ArrayValue"
  )
  @Nullable
  Uint32Array requiredNullableUint32ArrayValue();

  @JsProperty
  void setRequiredNullableUint32ArrayValue(@Nullable Uint32Array requiredNullableUint32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUint32ArrayValue requiredNullableUint32ArrayValue(
      @Nullable final Uint32Array requiredNullableUint32ArrayValue) {
    setRequiredNullableUint32ArrayValue( requiredNullableUint32ArrayValue );
    return this;
  }
}
