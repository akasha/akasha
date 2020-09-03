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
public interface Dictionary_requiredBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanFrozenArrayValue create(
      @Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
    return Js.<Dictionary_requiredBooleanFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredBooleanFrozenArrayValue"
  )
  @Nonnull
  JsArray<Boolean> requiredBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredBooleanFrozenArrayValue(
      @Nonnull JsArray<Boolean> requiredBooleanFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredBooleanFrozenArrayValue requiredBooleanFrozenArrayValue(
      @Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
    setRequiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
    return this;
  }
}
