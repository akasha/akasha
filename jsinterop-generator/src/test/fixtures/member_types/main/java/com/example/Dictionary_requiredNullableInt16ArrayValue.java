package com.example;

import elemental2.core.Int16Array;
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
public interface Dictionary_requiredNullableInt16ArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableInt16ArrayValue create(
      @Nullable final Int16Array requiredNullableInt16ArrayValue) {
    return Js.<Dictionary_requiredNullableInt16ArrayValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableInt16ArrayValue( requiredNullableInt16ArrayValue );
  }

  @JsProperty
  @Nullable
  Int16Array getRequiredNullableInt16ArrayValue();

  @JsProperty
  void setRequiredNullableInt16ArrayValue(@Nullable Int16Array requiredNullableInt16ArrayValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableInt16ArrayValue requiredNullableInt16ArrayValue(
      @Nullable final Int16Array requiredNullableInt16ArrayValue) {
    setRequiredNullableInt16ArrayValue( requiredNullableInt16ArrayValue );
    return this;
  }
}
