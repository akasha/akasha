package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "Dictionary_requiredObjectValue"
)
public interface Dictionary_requiredObjectValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsObject requiredObjectValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredObjectValue( requiredObjectValue );
  }

  @JsProperty(
      name = "requiredObjectValue"
  )
  @JsNonNull
  JsObject requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@JsNonNull JsObject requiredObjectValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredObjectValue"
  )
  interface Builder extends Dictionary_requiredObjectValue {
    @JsOverlay
    @Nonnull
    default Builder requiredObjectValue(@Nonnull final JsObject requiredObjectValue) {
      setRequiredObjectValue( requiredObjectValue );
      return this;
    }
  }
}
