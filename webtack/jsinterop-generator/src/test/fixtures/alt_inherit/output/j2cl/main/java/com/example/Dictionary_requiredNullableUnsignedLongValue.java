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
    name = "Dictionary_requiredNullableUnsignedLongValue"
)
public interface Dictionary_requiredNullableUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableUnsignedLongValue(
      @Nullable final Double requiredNullableUnsignedLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnsignedLongValue( requiredNullableUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedLongValue"
  )
  @JsNullable
  Double requiredNullableUnsignedLongValue();

  @JsProperty
  void setRequiredNullableUnsignedLongValue(@JsNullable Double requiredNullableUnsignedLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableUnsignedLongValue"
  )
  interface Builder extends Dictionary_requiredNullableUnsignedLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUnsignedLongValue(
        @Nullable final Double requiredNullableUnsignedLongValue) {
      setRequiredNullableUnsignedLongValue( requiredNullableUnsignedLongValue );
      return this;
    }
  }
}
