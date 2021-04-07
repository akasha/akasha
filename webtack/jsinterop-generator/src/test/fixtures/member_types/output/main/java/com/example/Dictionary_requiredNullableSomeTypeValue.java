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
    name = "Object"
)
public interface Dictionary_requiredNullableSomeTypeValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final SomeType requiredNullableSomeTypeValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeValue( requiredNullableSomeTypeValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeValue"
  )
  @Nullable
  SomeType requiredNullableSomeTypeValue();

  @JsProperty
  void setRequiredNullableSomeTypeValue(@Nullable SomeType requiredNullableSomeTypeValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableSomeTypeValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableSomeTypeValue(
        @Nullable final SomeType requiredNullableSomeTypeValue) {
      setRequiredNullableSomeTypeValue( requiredNullableSomeTypeValue );
      return this;
    }
  }
}
