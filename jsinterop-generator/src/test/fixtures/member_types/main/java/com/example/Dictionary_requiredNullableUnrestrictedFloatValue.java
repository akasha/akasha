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
public interface Dictionary_requiredNullableUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnrestrictedFloatValue create(
      @Nullable final Double requiredNullableUnrestrictedFloatValue) {
    return Js.<Dictionary_requiredNullableUnrestrictedFloatValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableUnrestrictedFloatValue( requiredNullableUnrestrictedFloatValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedFloatValue"
  )
  @Nullable
  Double requiredNullableUnrestrictedFloatValue();

  @JsProperty
  void setRequiredNullableUnrestrictedFloatValue(
      @Nullable Double requiredNullableUnrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableUnrestrictedFloatValue requiredNullableUnrestrictedFloatValue(
      @Nullable final Double requiredNullableUnrestrictedFloatValue) {
    setRequiredNullableUnrestrictedFloatValue( requiredNullableUnrestrictedFloatValue );
    return this;
  }
}
