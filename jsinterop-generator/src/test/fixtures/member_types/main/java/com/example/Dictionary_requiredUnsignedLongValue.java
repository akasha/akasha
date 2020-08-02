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
public interface Dictionary_requiredUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedLongValue create(final int requiredUnsignedLongValue) {
    return Js.<Dictionary_requiredUnsignedLongValue>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedLongValue( requiredUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredUnsignedLongValue"
  )
  int requiredUnsignedLongValue();

  @JsProperty
  void setRequiredUnsignedLongValue(int requiredUnsignedLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUnsignedLongValue requiredUnsignedLongValue(
      final int requiredUnsignedLongValue) {
    setRequiredUnsignedLongValue( requiredUnsignedLongValue );
    return this;
  }
}
