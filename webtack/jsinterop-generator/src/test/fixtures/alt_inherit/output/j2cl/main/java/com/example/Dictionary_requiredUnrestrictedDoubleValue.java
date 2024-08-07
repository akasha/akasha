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
    name = "Dictionary_requiredUnrestrictedDoubleValue"
)
public interface Dictionary_requiredUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Builder create(final double requiredUnrestrictedDoubleValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUnrestrictedDoubleValue( requiredUnrestrictedDoubleValue );
  }

  @JsProperty(
      name = "requiredUnrestrictedDoubleValue"
  )
  double requiredUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredUnrestrictedDoubleValue(double requiredUnrestrictedDoubleValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredUnrestrictedDoubleValue"
  )
  interface Builder extends Dictionary_requiredUnrestrictedDoubleValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUnrestrictedDoubleValue(final double requiredUnrestrictedDoubleValue) {
      setRequiredUnrestrictedDoubleValue( requiredUnrestrictedDoubleValue );
      return this;
    }
  }
}
