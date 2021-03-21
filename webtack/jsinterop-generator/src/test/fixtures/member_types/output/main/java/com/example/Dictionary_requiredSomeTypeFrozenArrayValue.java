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
    name = "Object"
)
public interface Dictionary_requiredSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeFrozenArrayValue create(
      @Nonnull final JsArray<SomeType> requiredSomeTypeFrozenArrayValue) {
    return Js.<Dictionary_requiredSomeTypeFrozenArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeFrozenArrayValue( requiredSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredSomeTypeFrozenArrayValue"
  )
  @Nonnull
  JsArray<SomeType> requiredSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredSomeTypeFrozenArrayValue(
      @Nonnull JsArray<SomeType> requiredSomeTypeFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredSomeTypeFrozenArrayValue requiredSomeTypeFrozenArrayValue(
      @Nonnull final JsArray<SomeType> requiredSomeTypeFrozenArrayValue) {
    setRequiredSomeTypeFrozenArrayValue( requiredSomeTypeFrozenArrayValue );
    return this;
  }
}
