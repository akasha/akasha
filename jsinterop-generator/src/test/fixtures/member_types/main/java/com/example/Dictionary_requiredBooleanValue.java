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
public interface Dictionary_requiredBooleanValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanValue create(final boolean requiredBooleanValue) {
    return Js.<Dictionary_requiredBooleanValue>uncheckedCast( JsPropertyMap.of() ).requiredBooleanValue( requiredBooleanValue );
  }

  @JsProperty(
      name = "requiredBooleanValue"
  )
  boolean requiredBooleanValue();

  @JsProperty
  void setRequiredBooleanValue(boolean requiredBooleanValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredBooleanValue requiredBooleanValue(final boolean requiredBooleanValue) {
    setRequiredBooleanValue( requiredBooleanValue );
    return this;
  }
}
