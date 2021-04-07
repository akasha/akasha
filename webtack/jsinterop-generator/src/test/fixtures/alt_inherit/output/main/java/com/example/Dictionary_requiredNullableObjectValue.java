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
public interface Dictionary_requiredNullableObjectValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final Object requiredNullableObjectValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableObjectValue( requiredNullableObjectValue );
  }

  @JsProperty(
      name = "requiredNullableObjectValue"
  )
  @Nullable
  Object requiredNullableObjectValue();

  @JsProperty
  void setRequiredNullableObjectValue(@Nullable Object requiredNullableObjectValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableObjectValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableObjectValue(
        @Nullable final Object requiredNullableObjectValue) {
      setRequiredNullableObjectValue( requiredNullableObjectValue );
      return this;
    }
  }
}
