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
public interface Dictionary_requiredNullableUSVStringValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final String requiredNullableUSVStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUSVStringValue( requiredNullableUSVStringValue );
  }

  @JsProperty(
      name = "requiredNullableUSVStringValue"
  )
  @Nullable
  String requiredNullableUSVStringValue();

  @JsProperty
  void setRequiredNullableUSVStringValue(@Nullable String requiredNullableUSVStringValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableUSVStringValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUSVStringValue(
        @Nullable final String requiredNullableUSVStringValue) {
      setRequiredNullableUSVStringValue( requiredNullableUSVStringValue );
      return this;
    }
  }
}
