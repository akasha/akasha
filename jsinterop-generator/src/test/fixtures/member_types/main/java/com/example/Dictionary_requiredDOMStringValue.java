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
public interface Dictionary_requiredDOMStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDOMStringValue create(@Nonnull final String requiredDOMStringValue) {
    return Js.<Dictionary_requiredDOMStringValue>uncheckedCast( JsPropertyMap.of() ).requiredDOMStringValue( requiredDOMStringValue );
  }

  @JsProperty(
      name = "requiredDOMStringValue"
  )
  @Nonnull
  String requiredDOMStringValue();

  @JsProperty
  void setRequiredDOMStringValue(@Nonnull String requiredDOMStringValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDOMStringValue requiredDOMStringValue(
      @Nonnull final String requiredDOMStringValue) {
    setRequiredDOMStringValue( requiredDOMStringValue );
    return this;
  }
}
