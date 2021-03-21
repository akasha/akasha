package com.example;

import com.other.JsArray;
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
public interface Dictionary_requiredFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatFrozenArrayValue create(
      @Nonnull final JsArray<Double> requiredFloatFrozenArrayValue) {
    return Js.<Dictionary_requiredFloatFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredFloatFrozenArrayValue( requiredFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredFloatFrozenArrayValue"
  )
  @Nonnull
  JsArray<Double> requiredFloatFrozenArrayValue();

  @JsProperty
  void setRequiredFloatFrozenArrayValue(@Nonnull JsArray<Double> requiredFloatFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloatFrozenArrayValue requiredFloatFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredFloatFrozenArrayValue) {
    setRequiredFloatFrozenArrayValue( requiredFloatFrozenArrayValue );
    return this;
  }
}
