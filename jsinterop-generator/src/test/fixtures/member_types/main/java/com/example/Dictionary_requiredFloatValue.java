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
public interface Dictionary_requiredFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatValue create(final float requiredFloatValue) {
    return Js.<Dictionary_requiredFloatValue>uncheckedCast( JsPropertyMap.of() ).requiredFloatValue( requiredFloatValue );
  }

  @JsProperty(
      name = "requiredFloatValue"
  )
  float requiredFloatValue();

  @JsProperty
  void setRequiredFloatValue(float requiredFloatValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredFloatValue requiredFloatValue(final float requiredFloatValue) {
    setRequiredFloatValue( requiredFloatValue );
    return this;
  }
}
