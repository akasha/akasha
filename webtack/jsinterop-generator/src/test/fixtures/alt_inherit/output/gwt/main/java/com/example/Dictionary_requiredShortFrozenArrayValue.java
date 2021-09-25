package com.example;

import com.other.JsArray;
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
public interface Dictionary_requiredShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder requiredShortFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredShortFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredShortFrozenArrayValue( requiredShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredShortFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredShortFrozenArrayValue();

  @JsProperty
  void setRequiredShortFrozenArrayValue(@JsNonNull JsArray<Double> requiredShortFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredShortFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredShortFrozenArrayValue(
        @Nonnull final JsArray<Double> requiredShortFrozenArrayValue) {
      setRequiredShortFrozenArrayValue( requiredShortFrozenArrayValue );
      return this;
    }
  }
}
