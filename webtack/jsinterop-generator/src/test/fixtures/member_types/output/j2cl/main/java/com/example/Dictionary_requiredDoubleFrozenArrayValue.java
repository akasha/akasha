package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "Dictionary_requiredDoubleFrozenArrayValue"
)
public interface Dictionary_requiredDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder requiredDoubleFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredDoubleFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredDoubleFrozenArrayValue(@JsNonNull JsArray<Double> requiredDoubleFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredDoubleFrozenArrayValue"
  )
  interface Builder extends Dictionary_requiredDoubleFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredDoubleFrozenArrayValue(
        @Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
      setRequiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
      return this;
    }
  }
}
