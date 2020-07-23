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
public interface Dictionary_requiredUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnrestrictedDoubleValue create(
      final double requiredUnrestrictedDoubleValue) {
    return Js.<Dictionary_requiredUnrestrictedDoubleValue>uncheckedCast( JsPropertyMap.of() ).requiredUnrestrictedDoubleValue( requiredUnrestrictedDoubleValue );
  }

  @JsProperty
  double getRequiredUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredUnrestrictedDoubleValue(double requiredUnrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUnrestrictedDoubleValue requiredUnrestrictedDoubleValue(
      final double requiredUnrestrictedDoubleValue) {
    setRequiredUnrestrictedDoubleValue( requiredUnrestrictedDoubleValue );
    return this;
  }
}
