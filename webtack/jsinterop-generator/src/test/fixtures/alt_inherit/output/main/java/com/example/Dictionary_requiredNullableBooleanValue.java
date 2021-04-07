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
public interface Dictionary_requiredNullableBooleanValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final Boolean requiredNullableBooleanValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanValue( requiredNullableBooleanValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanValue"
  )
  @Nullable
  Boolean requiredNullableBooleanValue();

  @JsProperty
  void setRequiredNullableBooleanValue(@Nullable Boolean requiredNullableBooleanValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableBooleanValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableBooleanValue(
        @Nullable final Boolean requiredNullableBooleanValue) {
      setRequiredNullableBooleanValue( requiredNullableBooleanValue );
      return this;
    }
  }
}
