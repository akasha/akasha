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
public interface Dictionary_requiredUSVStringValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final String requiredUSVStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUSVStringValue( requiredUSVStringValue );
  }

  @JsProperty(
      name = "requiredUSVStringValue"
  )
  @JsNonNull
  String requiredUSVStringValue();

  @JsProperty
  void setRequiredUSVStringValue(@JsNonNull String requiredUSVStringValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredUSVStringValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUSVStringValue(@Nonnull final String requiredUSVStringValue) {
      setRequiredUSVStringValue( requiredUSVStringValue );
      return this;
    }
  }
}
