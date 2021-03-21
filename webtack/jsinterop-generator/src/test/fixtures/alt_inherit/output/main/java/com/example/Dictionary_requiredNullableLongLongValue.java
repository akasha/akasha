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
    name = "Object"
)
public interface Dictionary_requiredNullableLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableLongLongValue create(
      @Nullable final Double requiredNullableLongLongValue) {
    return Js.<Dictionary_requiredNullableLongLongValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableLongLongValue( requiredNullableLongLongValue );
  }

  @JsProperty(
      name = "requiredNullableLongLongValue"
  )
  @Nullable
  Double requiredNullableLongLongValue();

  @JsProperty
  void setRequiredNullableLongLongValue(@Nullable Double requiredNullableLongLongValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableLongLongValue requiredNullableLongLongValue(
      @Nullable final Double requiredNullableLongLongValue) {
    setRequiredNullableLongLongValue( requiredNullableLongLongValue );
    return this;
  }
}
