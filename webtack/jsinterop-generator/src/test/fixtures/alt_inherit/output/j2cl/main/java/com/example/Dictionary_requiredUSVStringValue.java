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
    name = "Dictionary_requiredUSVStringValue"
)
public interface Dictionary_requiredUSVStringValue {
  @JsOverlay
  @Nonnull
  static Builder requiredUSVStringValue(@Nonnull final String requiredUSVStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUSVStringValue( requiredUSVStringValue );
  }

  @JsProperty(
      name = "requiredUSVStringValue"
  )
  @JsNonNull
  String requiredUSVStringValue();

  @JsProperty
  void setRequiredUSVStringValue(@JsNonNull String requiredUSVStringValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredUSVStringValue"
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
