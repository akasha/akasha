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
public interface Dictionary_requiredNullableBooleanValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanValue create(
      @Nullable final Boolean requiredNullableBooleanValue) {
    return Js.<Dictionary_requiredNullableBooleanValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanValue( requiredNullableBooleanValue );
  }

  @JsProperty
  @Nullable
  Boolean getRequiredNullableBooleanValue();

  @JsProperty
  void setRequiredNullableBooleanValue(@Nullable Boolean requiredNullableBooleanValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableBooleanValue requiredNullableBooleanValue(
      @Nullable final Boolean requiredNullableBooleanValue) {
    setRequiredNullableBooleanValue( requiredNullableBooleanValue );
    return this;
  }
}
