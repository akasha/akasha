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
    name = "Dictionary_requiredLongLongValue"
)
public interface Dictionary_requiredLongLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredLongLongValue(final int requiredLongLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredLongLongValue( requiredLongLongValue );
  }

  @JsProperty(
      name = "requiredLongLongValue"
  )
  int requiredLongLongValue();

  @JsProperty
  void setRequiredLongLongValue(int requiredLongLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredLongLongValue"
  )
  interface Builder extends Dictionary_requiredLongLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredLongLongValue(final int requiredLongLongValue) {
      setRequiredLongLongValue( requiredLongLongValue );
      return this;
    }
  }
}
