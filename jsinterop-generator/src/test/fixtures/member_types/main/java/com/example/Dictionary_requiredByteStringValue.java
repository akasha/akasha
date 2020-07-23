package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public interface Dictionary_requiredByteStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredByteStringValue create(@Nonnull final String requiredByteStringValue) {
    return Js.<Dictionary_requiredByteStringValue>uncheckedCast( JsPropertyMap.of() ).requiredByteStringValue( requiredByteStringValue );
  }

  @JsProperty
  @Nonnull
  String getRequiredByteStringValue();

  @JsProperty
  void setRequiredByteStringValue(@Nonnull String requiredByteStringValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredByteStringValue requiredByteStringValue(
      @Nonnull final String requiredByteStringValue) {
    setRequiredByteStringValue( requiredByteStringValue );
    return this;
  }
}
