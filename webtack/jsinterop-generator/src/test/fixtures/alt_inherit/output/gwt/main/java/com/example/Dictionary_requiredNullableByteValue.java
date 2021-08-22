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
    name = "Object"
)
public interface Dictionary_requiredNullableByteValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final Double requiredNullableByteValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableByteValue( requiredNullableByteValue );
  }

  @JsProperty(
      name = "requiredNullableByteValue"
  )
  @JsNullable
  Double requiredNullableByteValue();

  @JsProperty
  void setRequiredNullableByteValue(@JsNullable Double requiredNullableByteValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableByteValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableByteValue(@Nullable final Double requiredNullableByteValue) {
      setRequiredNullableByteValue( requiredNullableByteValue );
      return this;
    }
  }
}
