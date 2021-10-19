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
    name = "Dictionary_requiredNullableByteValue"
)
public interface Dictionary_requiredNullableByteValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableByteValue(@Nullable final Double requiredNullableByteValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableByteValue( requiredNullableByteValue );
  }

  @JsProperty(
      name = "requiredNullableByteValue"
  )
  @JsNullable
  Double requiredNullableByteValue();

  @JsProperty
  void setRequiredNullableByteValue(@JsNullable Double requiredNullableByteValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableByteValue"
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
