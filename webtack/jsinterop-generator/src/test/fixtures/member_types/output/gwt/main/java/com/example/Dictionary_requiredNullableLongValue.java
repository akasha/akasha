package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
public interface Dictionary_requiredNullableLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableLongValue(@Nullable final Double requiredNullableLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableLongValue( requiredNullableLongValue );
  }

  @JsProperty(
      name = "requiredNullableLongValue"
  )
  @JsNullable
  Double requiredNullableLongValue();

  @JsProperty
  void setRequiredNullableLongValue(@JsNullable Double requiredNullableLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableLongValue(@Nullable final Double requiredNullableLongValue) {
      setRequiredNullableLongValue( requiredNullableLongValue );
      return this;
    }
  }
}
