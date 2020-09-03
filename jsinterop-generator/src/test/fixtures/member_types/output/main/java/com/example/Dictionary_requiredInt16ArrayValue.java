package com.example;

import elemental2.core.Int16Array;
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
public interface Dictionary_requiredInt16ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredInt16ArrayValue create(
      @Nonnull final Int16Array requiredInt16ArrayValue) {
    return Js.<Dictionary_requiredInt16ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredInt16ArrayValue( requiredInt16ArrayValue );
  }

  @JsProperty(
      name = "requiredInt16ArrayValue"
  )
  @Nonnull
  Int16Array requiredInt16ArrayValue();

  @JsProperty
  void setRequiredInt16ArrayValue(@Nonnull Int16Array requiredInt16ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredInt16ArrayValue requiredInt16ArrayValue(
      @Nonnull final Int16Array requiredInt16ArrayValue) {
    setRequiredInt16ArrayValue( requiredInt16ArrayValue );
    return this;
  }
}
