package com.example;

import elemental3.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface Dictionary_requiredNullableBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanFrozenArrayValue create(
      @Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
    return Js.<Dictionary_requiredNullableBooleanFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanFrozenArrayValue"
  )
  @Nullable
  JsArray<Boolean> requiredNullableBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredNullableBooleanFrozenArrayValue(
      @Nullable JsArray<Boolean> requiredNullableBooleanFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableBooleanFrozenArrayValue requiredNullableBooleanFrozenArrayValue(
      @Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
    setRequiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
    return this;
  }
}
