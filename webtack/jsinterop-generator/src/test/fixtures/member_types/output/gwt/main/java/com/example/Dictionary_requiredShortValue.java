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
public interface Dictionary_requiredShortValue {
  @JsOverlay
  @Nonnull
  static Builder requiredShortValue(final short requiredShortValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredShortValue( requiredShortValue );
  }

  @JsProperty(
      name = "requiredShortValue"
  )
  short requiredShortValue();

  @JsProperty
  void setRequiredShortValue(short requiredShortValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredShortValue {
    @JsOverlay
    @Nonnull
    default Builder requiredShortValue(final short requiredShortValue) {
      setRequiredShortValue( requiredShortValue );
      return this;
    }
  }
}
