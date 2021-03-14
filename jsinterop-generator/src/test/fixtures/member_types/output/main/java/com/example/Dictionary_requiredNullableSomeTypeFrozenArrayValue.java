package com.example;

import akasha.lang.JsArray;
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
    name = "Object"
)
public interface Dictionary_requiredNullableSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeFrozenArrayValue create(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue) {
    return Js.<Dictionary_requiredNullableSomeTypeFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeFrozenArrayValue( requiredNullableSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeFrozenArrayValue"
  )
  @Nullable
  JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredNullableSomeTypeFrozenArrayValue(
      @Nullable JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSomeTypeFrozenArrayValue requiredNullableSomeTypeFrozenArrayValue(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue) {
    setRequiredNullableSomeTypeFrozenArrayValue( requiredNullableSomeTypeFrozenArrayValue );
    return this;
  }
}
