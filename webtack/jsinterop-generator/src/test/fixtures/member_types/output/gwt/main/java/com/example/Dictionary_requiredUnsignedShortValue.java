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
public interface Dictionary_requiredUnsignedShortValue {
  @JsOverlay
  @Nonnull
  static Builder create(final int requiredUnsignedShortValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUnsignedShortValue( requiredUnsignedShortValue );
  }

  @JsProperty(
      name = "requiredUnsignedShortValue"
  )
  int requiredUnsignedShortValue();

  @JsProperty
  void setRequiredUnsignedShortValue(int requiredUnsignedShortValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredUnsignedShortValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUnsignedShortValue(final int requiredUnsignedShortValue) {
      setRequiredUnsignedShortValue( requiredUnsignedShortValue );
      return this;
    }
  }
}
