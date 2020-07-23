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
    name = "?"
)
public interface Dictionary_requiredSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSomeTypeValue create(@Nonnull final SomeType requiredSomeTypeValue) {
    return Js.<Dictionary_requiredSomeTypeValue>uncheckedCast( JsPropertyMap.of() ).requiredSomeTypeValue( requiredSomeTypeValue );
  }

  @JsProperty
  @Nonnull
  SomeType getRequiredSomeTypeValue();

  @JsProperty
  void setRequiredSomeTypeValue(@Nonnull SomeType requiredSomeTypeValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredSomeTypeValue requiredSomeTypeValue(
      @Nonnull final SomeType requiredSomeTypeValue) {
    setRequiredSomeTypeValue( requiredSomeTypeValue );
    return this;
  }
}
