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
public interface Dictionary_requiredUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnrestrictedFloatValue create(
      final float requiredUnrestrictedFloatValue) {
    return Js.<Dictionary_requiredUnrestrictedFloatValue>uncheckedCast( JsPropertyMap.of() ).requiredUnrestrictedFloatValue( requiredUnrestrictedFloatValue );
  }

  @JsProperty
  float getRequiredUnrestrictedFloatValue();

  @JsProperty
  void setRequiredUnrestrictedFloatValue(float requiredUnrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredUnrestrictedFloatValue requiredUnrestrictedFloatValue(
      final float requiredUnrestrictedFloatValue) {
    setRequiredUnrestrictedFloatValue( requiredUnrestrictedFloatValue );
    return this;
  }
}
