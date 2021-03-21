package com.example;

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
    name = "Object"
)
public interface Dictionary_requiredShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortFrozenArrayValue create(
      @Nonnull final JsArray<Double> requiredShortFrozenArrayValue) {
    return Js.<Dictionary_requiredShortFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredShortFrozenArrayValue( requiredShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredShortFrozenArrayValue"
  )
  @Nonnull
  JsArray<Double> requiredShortFrozenArrayValue();

  @JsProperty
  void setRequiredShortFrozenArrayValue(@Nonnull JsArray<Double> requiredShortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredShortFrozenArrayValue requiredShortFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredShortFrozenArrayValue) {
    setRequiredShortFrozenArrayValue( requiredShortFrozenArrayValue );
    return this;
  }
}
