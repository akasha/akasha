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
    name = "Object"
)
public interface Dictionary_requiredUnsignedLongLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredUnsignedLongLongValue(final int requiredUnsignedLongLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedLongLongValue( requiredUnsignedLongLongValue );
  }

  @JsProperty(
      name = "requiredUnsignedLongLongValue"
  )
  int requiredUnsignedLongLongValue();

  @JsProperty
  void setRequiredUnsignedLongLongValue(int requiredUnsignedLongLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredUnsignedLongLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUnsignedLongLongValue(final int requiredUnsignedLongLongValue) {
      setRequiredUnsignedLongLongValue( requiredUnsignedLongLongValue );
      return this;
    }
  }
}
