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
public interface Dictionary_requiredUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnsignedShortValue create(final int requiredUnsignedShortValue) {
    return Js.<Dictionary_requiredUnsignedShortValue>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedShortValue( requiredUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredUnsignedShortValue"
  )
  int requiredUnsignedShortValue();

  @JsProperty
  void setRequiredUnsignedShortValue(int requiredUnsignedShortValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUnsignedShortValue requiredUnsignedShortValue(
      final int requiredUnsignedShortValue) {
    setRequiredUnsignedShortValue( requiredUnsignedShortValue );
    return this;
  }
}
