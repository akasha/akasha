package com.example;

import elemental2.core.Int8Array;
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
public interface Dictionary_requiredInt8ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredInt8ArrayValue create(@Nonnull final Int8Array requiredInt8ArrayValue) {
    return Js.<Dictionary_requiredInt8ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredInt8ArrayValue( requiredInt8ArrayValue );
  }

  @JsProperty(
      name = "requiredInt8ArrayValue"
  )
  @Nonnull
  Int8Array requiredInt8ArrayValue();

  @JsProperty
  void setRequiredInt8ArrayValue(@Nonnull Int8Array requiredInt8ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredInt8ArrayValue requiredInt8ArrayValue(
      @Nonnull final Int8Array requiredInt8ArrayValue) {
    setRequiredInt8ArrayValue( requiredInt8ArrayValue );
    return this;
  }
}
