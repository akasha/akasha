package com.example;

import elemental2.core.Float32Array;
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
public interface Dictionary_requiredNullableFloat32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloat32ArrayValue create(
      @Nullable final Float32Array requiredNullableFloat32ArrayValue) {
    return Js.<Dictionary_requiredNullableFloat32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloat32ArrayValue( requiredNullableFloat32ArrayValue );
  }

  @JsProperty(
      name = "requiredNullableFloat32ArrayValue"
  )
  @Nullable
  Float32Array requiredNullableFloat32ArrayValue();

  @JsProperty
  void setRequiredNullableFloat32ArrayValue(
      @Nullable Float32Array requiredNullableFloat32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableFloat32ArrayValue requiredNullableFloat32ArrayValue(
      @Nullable final Float32Array requiredNullableFloat32ArrayValue) {
    setRequiredNullableFloat32ArrayValue( requiredNullableFloat32ArrayValue );
    return this;
  }
}
