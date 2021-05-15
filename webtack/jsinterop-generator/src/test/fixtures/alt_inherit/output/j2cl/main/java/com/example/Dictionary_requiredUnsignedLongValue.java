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
    name = "Dictionary_requiredUnsignedLongValue"
)
public interface Dictionary_requiredUnsignedLongValue {
  @JsOverlay
  @Nonnull
  static Builder create(final int requiredUnsignedLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedLongValue( requiredUnsignedLongValue );
  }

  @JsProperty(
      name = "requiredUnsignedLongValue"
  )
  int requiredUnsignedLongValue();

  @JsProperty
  void setRequiredUnsignedLongValue(int requiredUnsignedLongValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredUnsignedLongValue"
  )
  interface Builder extends Dictionary_requiredUnsignedLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUnsignedLongValue(final int requiredUnsignedLongValue) {
      setRequiredUnsignedLongValue( requiredUnsignedLongValue );
      return this;
    }
  }
}
