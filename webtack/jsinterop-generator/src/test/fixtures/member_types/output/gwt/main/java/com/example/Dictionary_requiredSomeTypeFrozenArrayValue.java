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
public interface Dictionary_requiredSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<SomeType> requiredSomeTypeFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeFrozenArrayValue( requiredSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredSomeTypeFrozenArrayValue"
  )
  @JsNonNull
  JsArray<SomeType> requiredSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredSomeTypeFrozenArrayValue(
      @JsNonNull JsArray<SomeType> requiredSomeTypeFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredSomeTypeFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredSomeTypeFrozenArrayValue(
        @Nonnull final JsArray<SomeType> requiredSomeTypeFrozenArrayValue) {
      setRequiredSomeTypeFrozenArrayValue( requiredSomeTypeFrozenArrayValue );
      return this;
    }
  }
}
