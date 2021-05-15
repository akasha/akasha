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
    name = "Dictionary_requiredFloatValue"
)
public interface Dictionary_requiredFloatValue {
  @JsOverlay
  @Nonnull
  static Builder create(final float requiredFloatValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredFloatValue( requiredFloatValue );
  }

  @JsProperty(
      name = "requiredFloatValue"
  )
  float requiredFloatValue();

  @JsProperty
  void setRequiredFloatValue(float requiredFloatValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredFloatValue"
  )
  interface Builder extends Dictionary_requiredFloatValue {
    @JsOverlay
    @Nonnull
    default Builder requiredFloatValue(final float requiredFloatValue) {
      setRequiredFloatValue( requiredFloatValue );
      return this;
    }
  }
}
