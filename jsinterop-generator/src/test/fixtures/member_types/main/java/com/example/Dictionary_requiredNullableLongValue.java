package com.example;

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
public interface Dictionary_requiredNullableLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableLongValue create(
      @Nullable final Double requiredNullableLongValue) {
    return Js.<Dictionary_requiredNullableLongValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableLongValue( requiredNullableLongValue );
  }

  @JsProperty
  @Nullable
  Double getRequiredNullableLongValue();

  @JsProperty
  void setRequiredNullableLongValue(@Nullable Double requiredNullableLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableLongValue requiredNullableLongValue(
      @Nullable final Double requiredNullableLongValue) {
    setRequiredNullableLongValue( requiredNullableLongValue );
    return this;
  }
}
