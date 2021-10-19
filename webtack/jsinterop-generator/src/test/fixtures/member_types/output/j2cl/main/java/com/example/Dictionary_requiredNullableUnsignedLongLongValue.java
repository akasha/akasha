package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
    name = "Dictionary_requiredNullableUnsignedLongLongValue"
)
public interface Dictionary_requiredNullableUnsignedLongLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableUnsignedLongLongValue(
      @Nullable final Double requiredNullableUnsignedLongLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnsignedLongLongValue( requiredNullableUnsignedLongLongValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedLongLongValue"
  )
  @JsNullable
  Double requiredNullableUnsignedLongLongValue();

  @JsProperty
  void setRequiredNullableUnsignedLongLongValue(
      @JsNullable Double requiredNullableUnsignedLongLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableUnsignedLongLongValue"
  )
  interface Builder extends Dictionary_requiredNullableUnsignedLongLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUnsignedLongLongValue(
        @Nullable final Double requiredNullableUnsignedLongLongValue) {
      setRequiredNullableUnsignedLongLongValue( requiredNullableUnsignedLongLongValue );
      return this;
    }
  }
}
