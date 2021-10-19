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
    name = "Dictionary_requiredNullableByteStringValue"
)
public interface Dictionary_requiredNullableByteStringValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableByteStringValue(
      @Nullable final String requiredNullableByteStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableByteStringValue( requiredNullableByteStringValue );
  }

  @JsProperty(
      name = "requiredNullableByteStringValue"
  )
  @JsNullable
  String requiredNullableByteStringValue();

  @JsProperty
  void setRequiredNullableByteStringValue(@JsNullable String requiredNullableByteStringValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableByteStringValue"
  )
  interface Builder extends Dictionary_requiredNullableByteStringValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableByteStringValue(
        @Nullable final String requiredNullableByteStringValue) {
      setRequiredNullableByteStringValue( requiredNullableByteStringValue );
      return this;
    }
  }
}
