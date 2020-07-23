package com.example;

import elemental2.core.Float32Array;
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
public interface Dictionary_requiredFloat32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloat32ArrayValue create(
      @Nonnull final Float32Array requiredFloat32ArrayValue) {
    return Js.<Dictionary_requiredFloat32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredFloat32ArrayValue( requiredFloat32ArrayValue );
  }

  @JsProperty
  @Nonnull
  Float32Array getRequiredFloat32ArrayValue();

  @JsProperty
  void setRequiredFloat32ArrayValue(@Nonnull Float32Array requiredFloat32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloat32ArrayValue requiredFloat32ArrayValue(
      @Nonnull final Float32Array requiredFloat32ArrayValue) {
    setRequiredFloat32ArrayValue( requiredFloat32ArrayValue );
    return this;
  }
}
