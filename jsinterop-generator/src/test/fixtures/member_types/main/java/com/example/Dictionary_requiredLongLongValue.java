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
public interface Dictionary_requiredLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredLongLongValue create(final int requiredLongLongValue) {
    return Js.<Dictionary_requiredLongLongValue>uncheckedCast( JsPropertyMap.of() ).requiredLongLongValue( requiredLongLongValue );
  }

  @JsProperty
  int getRequiredLongLongValue();

  @JsProperty
  void setRequiredLongLongValue(int requiredLongLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredLongLongValue requiredLongLongValue(final int requiredLongLongValue) {
    setRequiredLongLongValue( requiredLongLongValue );
    return this;
  }
}
