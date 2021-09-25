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
public interface Dictionary_requiredNullableDoubleValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableDoubleValue(@Nullable final Double requiredNullableDoubleValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableDoubleValue( requiredNullableDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleValue"
  )
  @JsNullable
  Double requiredNullableDoubleValue();

  @JsProperty
  void setRequiredNullableDoubleValue(@JsNullable Double requiredNullableDoubleValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableDoubleValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableDoubleValue(
        @Nullable final Double requiredNullableDoubleValue) {
      setRequiredNullableDoubleValue( requiredNullableDoubleValue );
      return this;
    }
  }
}
