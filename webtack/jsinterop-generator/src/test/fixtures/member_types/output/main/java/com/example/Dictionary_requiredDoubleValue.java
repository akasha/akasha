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
public interface Dictionary_requiredDoubleValue {
  @JsOverlay
  @Nonnull
  static Builder create(final double requiredDoubleValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredDoubleValue( requiredDoubleValue );
  }

  @JsProperty(
      name = "requiredDoubleValue"
  )
  double requiredDoubleValue();

  @JsProperty
  void setRequiredDoubleValue(double requiredDoubleValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredDoubleValue {
    @JsOverlay
    @Nonnull
    default Builder requiredDoubleValue(final double requiredDoubleValue) {
      setRequiredDoubleValue( requiredDoubleValue );
      return this;
    }
  }
}
