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
    name = "?"
)
public interface Dictionary_requiredNullableByteStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableByteStringValue create(
      @Nullable final String requiredNullableByteStringValue) {
    return Js.<Dictionary_requiredNullableByteStringValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableByteStringValue( requiredNullableByteStringValue );
  }

  @JsProperty(
      name = "requiredNullableByteStringValue"
  )
  @Nullable
  String requiredNullableByteStringValue();

  @JsProperty
  void setRequiredNullableByteStringValue(@Nullable String requiredNullableByteStringValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableByteStringValue requiredNullableByteStringValue(
      @Nullable final String requiredNullableByteStringValue) {
    setRequiredNullableByteStringValue( requiredNullableByteStringValue );
    return this;
  }
}
