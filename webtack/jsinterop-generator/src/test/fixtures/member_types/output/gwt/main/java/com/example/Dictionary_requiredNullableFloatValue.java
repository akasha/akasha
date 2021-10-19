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
public interface Dictionary_requiredNullableFloatValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableFloatValue(@Nullable final Double requiredNullableFloatValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableFloatValue( requiredNullableFloatValue );
  }

  @JsProperty(
      name = "requiredNullableFloatValue"
  )
  @JsNullable
  Double requiredNullableFloatValue();

  @JsProperty
  void setRequiredNullableFloatValue(@JsNullable Double requiredNullableFloatValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableFloatValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableFloatValue(@Nullable final Double requiredNullableFloatValue) {
      setRequiredNullableFloatValue( requiredNullableFloatValue );
      return this;
    }
  }
}
