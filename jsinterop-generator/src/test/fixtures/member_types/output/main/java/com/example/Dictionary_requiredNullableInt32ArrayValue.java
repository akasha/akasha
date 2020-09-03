package com.example;

import elemental2.core.Int32Array;
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
public interface Dictionary_requiredNullableInt32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableInt32ArrayValue create(
      @Nullable final Int32Array requiredNullableInt32ArrayValue) {
    return Js.<Dictionary_requiredNullableInt32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableInt32ArrayValue( requiredNullableInt32ArrayValue );
  }

  @JsProperty(
      name = "requiredNullableInt32ArrayValue"
  )
  @Nullable
  Int32Array requiredNullableInt32ArrayValue();

  @JsProperty
  void setRequiredNullableInt32ArrayValue(@Nullable Int32Array requiredNullableInt32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableInt32ArrayValue requiredNullableInt32ArrayValue(
      @Nullable final Int32Array requiredNullableInt32ArrayValue) {
    setRequiredNullableInt32ArrayValue( requiredNullableInt32ArrayValue );
    return this;
  }
}
