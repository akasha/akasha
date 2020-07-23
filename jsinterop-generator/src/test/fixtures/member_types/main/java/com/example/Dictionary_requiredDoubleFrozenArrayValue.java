package com.example;

import elemental2.core.JsArray;
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
public interface Dictionary_requiredDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleFrozenArrayValue create(
      @Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
    return Js.<Dictionary_requiredDoubleFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
  }

  @JsProperty
  @Nonnull
  JsArray<Double> getRequiredDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredDoubleFrozenArrayValue(@Nonnull JsArray<Double> requiredDoubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDoubleFrozenArrayValue requiredDoubleFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
    setRequiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
    return this;
  }
}
