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
public interface Dictionary_requiredLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredLongValue create(final int requiredLongValue) {
    return Js.<Dictionary_requiredLongValue>uncheckedCast( JsPropertyMap.of() ).requiredLongValue( requiredLongValue );
  }

  @JsProperty
  int getRequiredLongValue();

  @JsProperty
  void setRequiredLongValue(int requiredLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredLongValue requiredLongValue(final int requiredLongValue) {
    setRequiredLongValue( requiredLongValue );
    return this;
  }
}
