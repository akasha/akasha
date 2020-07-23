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
public interface Dictionary_requiredUnsignedLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedLongLongValue create(final int requiredUnsignedLongLongValue) {
    return Js.<Dictionary_requiredUnsignedLongLongValue>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedLongLongValue( requiredUnsignedLongLongValue );
  }

  @JsProperty
  int getRequiredUnsignedLongLongValue();

  @JsProperty
  void setRequiredUnsignedLongLongValue(int requiredUnsignedLongLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUnsignedLongLongValue requiredUnsignedLongLongValue(
      final int requiredUnsignedLongLongValue) {
    setRequiredUnsignedLongLongValue( requiredUnsignedLongLongValue );
    return this;
  }
}
