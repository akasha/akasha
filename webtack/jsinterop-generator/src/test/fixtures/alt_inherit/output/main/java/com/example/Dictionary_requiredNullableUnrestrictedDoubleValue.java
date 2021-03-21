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
public interface Dictionary_requiredNullableUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnrestrictedDoubleValue create(
      @Nullable final Double requiredNullableUnrestrictedDoubleValue) {
    return Js.<Dictionary_requiredNullableUnrestrictedDoubleValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnrestrictedDoubleValue( requiredNullableUnrestrictedDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedDoubleValue"
  )
  @Nullable
  Double requiredNullableUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredNullableUnrestrictedDoubleValue(
      @Nullable Double requiredNullableUnrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUnrestrictedDoubleValue requiredNullableUnrestrictedDoubleValue(
      @Nullable final Double requiredNullableUnrestrictedDoubleValue) {
    setRequiredNullableUnrestrictedDoubleValue( requiredNullableUnrestrictedDoubleValue );
    return this;
  }
}
