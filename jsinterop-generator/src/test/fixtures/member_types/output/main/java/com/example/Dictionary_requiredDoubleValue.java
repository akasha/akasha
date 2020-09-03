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
public interface Dictionary_requiredDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleValue create(final double requiredDoubleValue) {
    return Js.<Dictionary_requiredDoubleValue>uncheckedCast( JsPropertyMap.of() ).requiredDoubleValue( requiredDoubleValue );
  }

  @JsProperty(
      name = "requiredDoubleValue"
  )
  double requiredDoubleValue();

  @JsProperty
  void setRequiredDoubleValue(double requiredDoubleValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDoubleValue requiredDoubleValue(final double requiredDoubleValue) {
    setRequiredDoubleValue( requiredDoubleValue );
    return this;
  }
}
