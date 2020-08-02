package com.example;

import elemental2.core.Uint16Array;
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
public interface Dictionary_requiredNullableUint16ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUint16ArrayValue create(
      @Nullable final Uint16Array requiredNullableUint16ArrayValue) {
    return Js.<Dictionary_requiredNullableUint16ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUint16ArrayValue( requiredNullableUint16ArrayValue );
  }

  @JsProperty(
      name = "requiredNullableUint16ArrayValue"
  )
  @Nullable
  Uint16Array requiredNullableUint16ArrayValue();

  @JsProperty
  void setRequiredNullableUint16ArrayValue(@Nullable Uint16Array requiredNullableUint16ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUint16ArrayValue requiredNullableUint16ArrayValue(
      @Nullable final Uint16Array requiredNullableUint16ArrayValue) {
    setRequiredNullableUint16ArrayValue( requiredNullableUint16ArrayValue );
    return this;
  }
}
