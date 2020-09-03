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
public interface Dictionary_requiredNullableDOMStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDOMStringValue create(
      @Nullable final String requiredNullableDOMStringValue) {
    return Js.<Dictionary_requiredNullableDOMStringValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDOMStringValue( requiredNullableDOMStringValue );
  }

  @JsProperty(
      name = "requiredNullableDOMStringValue"
  )
  @Nullable
  String requiredNullableDOMStringValue();

  @JsProperty
  void setRequiredNullableDOMStringValue(@Nullable String requiredNullableDOMStringValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDOMStringValue requiredNullableDOMStringValue(
      @Nullable final String requiredNullableDOMStringValue) {
    setRequiredNullableDOMStringValue( requiredNullableDOMStringValue );
    return this;
  }
}
