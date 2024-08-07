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
    name = "Dictionary_requiredNullableUnrestrictedFloatValue"
)
public interface Dictionary_requiredNullableUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final Double requiredNullableUnrestrictedFloatValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnrestrictedFloatValue( requiredNullableUnrestrictedFloatValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedFloatValue"
  )
  @JsNullable
  Double requiredNullableUnrestrictedFloatValue();

  @JsProperty
  void setRequiredNullableUnrestrictedFloatValue(
      @JsNullable Double requiredNullableUnrestrictedFloatValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableUnrestrictedFloatValue"
  )
  interface Builder extends Dictionary_requiredNullableUnrestrictedFloatValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUnrestrictedFloatValue(
        @Nullable final Double requiredNullableUnrestrictedFloatValue) {
      setRequiredNullableUnrestrictedFloatValue( requiredNullableUnrestrictedFloatValue );
      return this;
    }
  }
}
