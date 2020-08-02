package com.example;

import elemental2.core.Symbol;
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
public interface Dictionary_requiredSymbolValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredSymbolValue create(@Nonnull final Symbol requiredSymbolValue) {
    return Js.<Dictionary_requiredSymbolValue>uncheckedCast( JsPropertyMap.of() ).requiredSymbolValue( requiredSymbolValue );
  }

  @JsProperty(
      name = "requiredSymbolValue"
  )
  @Nonnull
  Symbol requiredSymbolValue();

  @JsProperty
  void setRequiredSymbolValue(@Nonnull Symbol requiredSymbolValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredSymbolValue requiredSymbolValue(
      @Nonnull final Symbol requiredSymbolValue) {
    setRequiredSymbolValue( requiredSymbolValue );
    return this;
  }
}
