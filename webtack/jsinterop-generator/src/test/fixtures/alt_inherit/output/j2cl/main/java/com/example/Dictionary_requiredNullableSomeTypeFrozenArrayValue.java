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
    name = "Dictionary_requiredNullableSomeTypeFrozenArrayValue"
)
public interface Dictionary_requiredNullableSomeTypeFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Builder create(
      @Nullable final JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableSomeTypeFrozenArrayValue( requiredNullableSomeTypeFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableSomeTypeFrozenArrayValue"
  )
  @Nullable
  JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue();

  @JsProperty
  void setRequiredNullableSomeTypeFrozenArrayValue(
      @Nullable JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableSomeTypeFrozenArrayValue"
  )
  interface Builder extends Dictionary_requiredNullableSomeTypeFrozenArrayValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableSomeTypeFrozenArrayValue(
        @Nullable final JsArray<SomeType> requiredNullableSomeTypeFrozenArrayValue) {
      setRequiredNullableSomeTypeFrozenArrayValue( requiredNullableSomeTypeFrozenArrayValue );
      return this;
    }
  }
}
