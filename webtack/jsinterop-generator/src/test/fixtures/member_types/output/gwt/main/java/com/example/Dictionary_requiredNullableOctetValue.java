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
public interface Dictionary_requiredNullableOctetValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final Double requiredNullableOctetValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableOctetValue( requiredNullableOctetValue );
  }

  @JsProperty(
      name = "requiredNullableOctetValue"
  )
  @Nullable
  Double requiredNullableOctetValue();

  @JsProperty
  void setRequiredNullableOctetValue(@Nullable Double requiredNullableOctetValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableOctetValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableOctetValue(@Nullable final Double requiredNullableOctetValue) {
      setRequiredNullableOctetValue( requiredNullableOctetValue );
      return this;
    }
  }
}
