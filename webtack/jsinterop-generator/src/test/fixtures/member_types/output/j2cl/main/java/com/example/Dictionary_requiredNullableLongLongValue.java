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
    name = "Dictionary_requiredNullableLongLongValue"
)
public interface Dictionary_requiredNullableLongLongValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableLongLongValue(
      @Nullable final Double requiredNullableLongLongValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableLongLongValue( requiredNullableLongLongValue );
  }

  @JsProperty(
      name = "requiredNullableLongLongValue"
  )
  @JsNullable
  Double requiredNullableLongLongValue();

  @JsProperty
  void setRequiredNullableLongLongValue(@JsNullable Double requiredNullableLongLongValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableLongLongValue"
  )
  interface Builder extends Dictionary_requiredNullableLongLongValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableLongLongValue(
        @Nullable final Double requiredNullableLongLongValue) {
      setRequiredNullableLongLongValue( requiredNullableLongLongValue );
      return this;
    }
  }
}
