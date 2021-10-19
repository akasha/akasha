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
public interface Dictionary_requiredNullableUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableUnsignedShortValue(
      @Nullable final Double requiredNullableUnsignedShortValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnsignedShortValue( requiredNullableUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredNullableUnsignedShortValue"
  )
  @JsNullable
  Double requiredNullableUnsignedShortValue();

  @JsProperty
  void setRequiredNullableUnsignedShortValue(@JsNullable Double requiredNullableUnsignedShortValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableUnsignedShortValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUnsignedShortValue(
        @Nullable final Double requiredNullableUnsignedShortValue) {
      setRequiredNullableUnsignedShortValue( requiredNullableUnsignedShortValue );
      return this;
    }
  }
}
