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
public interface Dictionary_requiredBooleanValue {
  @JsOverlay
  @Nonnull
  static Builder create(final boolean requiredBooleanValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredBooleanValue( requiredBooleanValue );
  }

  @JsProperty(
      name = "requiredBooleanValue"
  )
  boolean requiredBooleanValue();

  @JsProperty
  void setRequiredBooleanValue(boolean requiredBooleanValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredBooleanValue {
    @JsOverlay
    @Nonnull
    default Builder requiredBooleanValue(final boolean requiredBooleanValue) {
      setRequiredBooleanValue( requiredBooleanValue );
      return this;
    }
  }
}
