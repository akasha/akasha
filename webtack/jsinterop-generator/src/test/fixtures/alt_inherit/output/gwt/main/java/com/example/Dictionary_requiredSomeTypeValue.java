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
public interface Dictionary_requiredSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final SomeType requiredSomeTypeValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeValue( requiredSomeTypeValue );
  }

  @JsProperty(
      name = "requiredSomeTypeValue"
  )
  @JsNonNull
  SomeType requiredSomeTypeValue();

  @JsProperty
  void setRequiredSomeTypeValue(@JsNonNull SomeType requiredSomeTypeValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredSomeTypeValue {
    @JsOverlay
    @Nonnull
    default Builder requiredSomeTypeValue(@Nonnull final SomeType requiredSomeTypeValue) {
      setRequiredSomeTypeValue( requiredSomeTypeValue );
      return this;
    }
  }
}
