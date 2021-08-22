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
    name = "Object"
)
public interface Dictionary_requiredFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Double> requiredFloatFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredFloatFrozenArrayValue( requiredFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredFloatFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredFloatFrozenArrayValue();

  @JsProperty
  void setRequiredFloatFrozenArrayValue(@JsNonNull JsArray<Double> requiredFloatFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredFloatFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredFloatFrozenArrayValue(
        @Nonnull final JsArray<Double> requiredFloatFrozenArrayValue) {
      setRequiredFloatFrozenArrayValue( requiredFloatFrozenArrayValue );
      return this;
    }
  }
}
