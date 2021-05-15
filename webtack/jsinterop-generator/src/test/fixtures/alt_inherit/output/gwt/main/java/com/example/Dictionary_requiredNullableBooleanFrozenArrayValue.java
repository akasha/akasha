package com.example;

import com.other.JsArray;
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
public interface Dictionary_requiredNullableBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanFrozenArrayValue"
  )
  @Nullable
  JsArray<Boolean> requiredNullableBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredNullableBooleanFrozenArrayValue(
      @Nullable JsArray<Boolean> requiredNullableBooleanFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredNullableBooleanFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableBooleanFrozenArrayValue(
        @Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
      setRequiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
      return this;
    }
  }
}
