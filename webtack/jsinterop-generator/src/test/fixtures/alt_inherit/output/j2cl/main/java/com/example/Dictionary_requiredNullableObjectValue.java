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
    name = "Dictionary_requiredNullableObjectValue"
)
public interface Dictionary_requiredNullableObjectValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsObject requiredNullableObjectValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableObjectValue( requiredNullableObjectValue );
  }

  @JsProperty(
      name = "requiredNullableObjectValue"
  )
  @JsNullable
  JsObject requiredNullableObjectValue();

  @JsProperty
  void setRequiredNullableObjectValue(@JsNullable JsObject requiredNullableObjectValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableObjectValue"
  )
  interface Builder extends Dictionary_requiredNullableObjectValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableObjectValue(
        @Nullable final JsObject requiredNullableObjectValue) {
      setRequiredNullableObjectValue( requiredNullableObjectValue );
      return this;
    }
  }
}
