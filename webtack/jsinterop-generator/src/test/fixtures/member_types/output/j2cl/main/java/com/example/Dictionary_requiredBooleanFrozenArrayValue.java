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
    name = "Dictionary_requiredBooleanFrozenArrayValue"
)
public interface Dictionary_requiredBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredBooleanFrozenArrayValue"
  )
  @Nonnull
  JsArray<Boolean> requiredBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredBooleanFrozenArrayValue(
      @Nonnull JsArray<Boolean> requiredBooleanFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredBooleanFrozenArrayValue"
  )
  interface Builder extends Dictionary_requiredBooleanFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredBooleanFrozenArrayValue(
        @Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
      setRequiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
      return this;
    }
  }
}
