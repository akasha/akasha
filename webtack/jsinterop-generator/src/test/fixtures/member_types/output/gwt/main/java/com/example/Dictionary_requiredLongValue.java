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
public interface Dictionary_requiredLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredLongValue(final int requiredLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredLongValue( requiredLongValue );
  }

  @JsProperty(
      name = "requiredLongValue"
  )
  int requiredLongValue();

  @JsProperty
  void setRequiredLongValue(int requiredLongValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredLongValue(final int requiredLongValue) {
      setRequiredLongValue( requiredLongValue );
      return this;
    }
  }
}
