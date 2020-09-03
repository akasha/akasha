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
public interface Dictionary_requiredNullableObjectValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableObjectValue create(
      @Nullable final Object requiredNullableObjectValue) {
    return Js.<Dictionary_requiredNullableObjectValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableObjectValue( requiredNullableObjectValue );
  }

  @JsProperty(
      name = "requiredNullableObjectValue"
  )
  @Nullable
  Object requiredNullableObjectValue();

  @JsProperty
  void setRequiredNullableObjectValue(@Nullable Object requiredNullableObjectValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableObjectValue requiredNullableObjectValue(
      @Nullable final Object requiredNullableObjectValue) {
    setRequiredNullableObjectValue( requiredNullableObjectValue );
    return this;
  }
}
