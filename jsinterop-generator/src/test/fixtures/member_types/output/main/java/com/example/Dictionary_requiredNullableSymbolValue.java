package com.example;

import elemental3.core.Symbol;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
public interface Dictionary_requiredNullableSymbolValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableSymbolValue create(
      @Nullable final Symbol requiredNullableSymbolValue) {
    return Js.<Dictionary_requiredNullableSymbolValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableSymbolValue( requiredNullableSymbolValue );
  }

  @JsProperty(
      name = "requiredNullableSymbolValue"
  )
  @Nullable
  Symbol requiredNullableSymbolValue();

  @JsProperty
  void setRequiredNullableSymbolValue(@Nullable Symbol requiredNullableSymbolValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableSymbolValue requiredNullableSymbolValue(
      @Nullable final Symbol requiredNullableSymbolValue) {
    setRequiredNullableSymbolValue( requiredNullableSymbolValue );
    return this;
  }
}
