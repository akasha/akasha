package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
public interface Dictionary_requiredByteStringValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final String requiredByteStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredByteStringValue( requiredByteStringValue );
  }

  @JsProperty(
      name = "requiredByteStringValue"
  )
  @JsNonNull
  String requiredByteStringValue();

  @JsProperty
  void setRequiredByteStringValue(@JsNonNull String requiredByteStringValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredByteStringValue {
    @JsOverlay
    @Nonnull
    default Builder requiredByteStringValue(@Nonnull final String requiredByteStringValue) {
      setRequiredByteStringValue( requiredByteStringValue );
      return this;
    }
  }
}
