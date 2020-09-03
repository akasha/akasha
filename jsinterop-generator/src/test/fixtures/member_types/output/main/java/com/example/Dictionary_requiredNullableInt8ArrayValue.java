package com.example;

import elemental2.core.Int8Array;
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
public interface Dictionary_requiredNullableInt8ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableInt8ArrayValue create(
      @Nullable final Int8Array requiredNullableInt8ArrayValue) {
    return Js.<Dictionary_requiredNullableInt8ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableInt8ArrayValue( requiredNullableInt8ArrayValue );
  }

  @JsProperty(
      name = "requiredNullableInt8ArrayValue"
  )
  @Nullable
  Int8Array requiredNullableInt8ArrayValue();

  @JsProperty
  void setRequiredNullableInt8ArrayValue(@Nullable Int8Array requiredNullableInt8ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableInt8ArrayValue requiredNullableInt8ArrayValue(
      @Nullable final Int8Array requiredNullableInt8ArrayValue) {
    setRequiredNullableInt8ArrayValue( requiredNullableInt8ArrayValue );
    return this;
  }
}
