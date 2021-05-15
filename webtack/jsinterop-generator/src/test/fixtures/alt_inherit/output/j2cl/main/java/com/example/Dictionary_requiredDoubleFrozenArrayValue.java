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
public interface Dictionary_requiredDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredDoubleFrozenArrayValue"
  )
  @Nonnull
  JsArray<Double> requiredDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredDoubleFrozenArrayValue(@Nonnull JsArray<Double> requiredDoubleFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
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
