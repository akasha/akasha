package com.example;

import elemental2.core.Int32Array;
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
public interface Dictionary_requiredInt32ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredInt32ArrayValue create(
      @Nonnull final Int32Array requiredInt32ArrayValue) {
    return Js.<Dictionary_requiredInt32ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredInt32ArrayValue( requiredInt32ArrayValue );
  }

  @JsProperty(
      name = "requiredInt32ArrayValue"
  )
  @Nonnull
  Int32Array requiredInt32ArrayValue();

  @JsProperty
  void setRequiredInt32ArrayValue(@Nonnull Int32Array requiredInt32ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredInt32ArrayValue requiredInt32ArrayValue(
      @Nonnull final Int32Array requiredInt32ArrayValue) {
    setRequiredInt32ArrayValue( requiredInt32ArrayValue );
    return this;
  }
}
