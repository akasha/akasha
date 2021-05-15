package com.example;

import com.other.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public interface Dictionary_requiredBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredBooleanFrozenArrayValue"
  )
  @Nonnull
  JsArray<Boolean> requiredBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredBooleanFrozenArrayValue(
      @Nonnull JsArray<Boolean> requiredBooleanFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredBooleanFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredBooleanFrozenArrayValue(
        @Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
      setRequiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
      return this;
    }
  }
}
