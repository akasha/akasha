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
public interface Dictionary_requiredUSVStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUSVStringValue create(@Nonnull final String requiredUSVStringValue) {
    return Js.<Dictionary_requiredUSVStringValue>uncheckedCast( JsPropertyMap.of() ).requiredUSVStringValue( requiredUSVStringValue );
  }

  @JsProperty(
      name = "requiredUSVStringValue"
  )
  @Nonnull
  String requiredUSVStringValue();

  @JsProperty
  void setRequiredUSVStringValue(@Nonnull String requiredUSVStringValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUSVStringValue requiredUSVStringValue(
      @Nonnull final String requiredUSVStringValue) {
    setRequiredUSVStringValue( requiredUSVStringValue );
    return this;
  }
}
