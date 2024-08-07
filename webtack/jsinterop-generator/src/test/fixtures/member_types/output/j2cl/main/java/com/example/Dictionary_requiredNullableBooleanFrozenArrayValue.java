package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
    name = "Dictionary_requiredNullableBooleanFrozenArrayValue"
)
public interface Dictionary_requiredNullableBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanFrozenArrayValue"
  )
  @JsNullable
  JsArray<Boolean> requiredNullableBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredNullableBooleanFrozenArrayValue(
      @JsNullable JsArray<Boolean> requiredNullableBooleanFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableBooleanFrozenArrayValue"
  )
  interface Builder extends Dictionary_requiredNullableBooleanFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableBooleanFrozenArrayValue(
        @Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
      setRequiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
      return this;
    }
  }
}
