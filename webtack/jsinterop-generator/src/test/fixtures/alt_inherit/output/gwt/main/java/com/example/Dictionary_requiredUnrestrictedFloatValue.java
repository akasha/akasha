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
public interface Dictionary_requiredUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Builder requiredUnrestrictedFloatValue(final float requiredUnrestrictedFloatValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredUnrestrictedFloatValue( requiredUnrestrictedFloatValue );
  }

  @JsProperty(
      name = "requiredUnrestrictedFloatValue"
  )
  float requiredUnrestrictedFloatValue();

  @JsProperty
  void setRequiredUnrestrictedFloatValue(float requiredUnrestrictedFloatValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredUnrestrictedFloatValue {
    @JsOverlay
    @Nonnull
    default Builder requiredUnrestrictedFloatValue(final float requiredUnrestrictedFloatValue) {
      setRequiredUnrestrictedFloatValue( requiredUnrestrictedFloatValue );
      return this;
    }
  }
}
