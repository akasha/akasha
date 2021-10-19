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
    name = "Dictionary_requiredNullableUnrestrictedDoubleValue"
)
public interface Dictionary_requiredNullableUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Builder requiredNullableUnrestrictedDoubleValue(
      @Nullable final Double requiredNullableUnrestrictedDoubleValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnrestrictedDoubleValue( requiredNullableUnrestrictedDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedDoubleValue"
  )
  @JsNullable
  Double requiredNullableUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredNullableUnrestrictedDoubleValue(
      @JsNullable Double requiredNullableUnrestrictedDoubleValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableUnrestrictedDoubleValue"
  )
  interface Builder extends Dictionary_requiredNullableUnrestrictedDoubleValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableUnrestrictedDoubleValue(
        @Nullable final Double requiredNullableUnrestrictedDoubleValue) {
      setRequiredNullableUnrestrictedDoubleValue( requiredNullableUnrestrictedDoubleValue );
      return this;
    }
  }
}
