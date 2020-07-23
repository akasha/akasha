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
public interface Dictionary_requiredObjectValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredObjectValue create(@Nonnull final Object requiredObjectValue) {
    return Js.<Dictionary_requiredObjectValue>uncheckedCast( JsPropertyMap.of() ).requiredObjectValue( requiredObjectValue );
  }

  @JsProperty
  @Nonnull
  Object getRequiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@Nonnull Object requiredObjectValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredObjectValue requiredObjectValue(
      @Nonnull final Object requiredObjectValue) {
    setRequiredObjectValue( requiredObjectValue );
    return this;
  }
}
