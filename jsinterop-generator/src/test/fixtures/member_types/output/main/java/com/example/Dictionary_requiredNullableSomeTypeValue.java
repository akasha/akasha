package com.example;

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
public interface Dictionary_requiredNullableSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSomeTypeValue create(
      @Nullable final SomeType requiredNullableSomeTypeValue) {
    return Js.<Dictionary_requiredNullableSomeTypeValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeValue( requiredNullableSomeTypeValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeValue"
  )
  @Nullable
  SomeType requiredNullableSomeTypeValue();

  @JsProperty
  void setRequiredNullableSomeTypeValue(@Nullable SomeType requiredNullableSomeTypeValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSomeTypeValue requiredNullableSomeTypeValue(
      @Nullable final SomeType requiredNullableSomeTypeValue) {
    setRequiredNullableSomeTypeValue( requiredNullableSomeTypeValue );
    return this;
  }
}
