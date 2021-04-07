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
public interface MyDictionary {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final Object requiredObjectValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredObjectValue( requiredObjectValue );
  }

  @JsProperty(
      name = "nullableObjectValue"
  )
  @Nullable
  Object nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@Nullable Object nullableObjectValue);

  @JsProperty(
      name = "objectValue"
  )
  Object objectValue();

  @JsProperty
  void setObjectValue(@Nonnull Object objectValue);

  @JsProperty(
      name = "requiredObjectValue"
  )
  @Nonnull
  Object requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@Nonnull Object requiredObjectValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends MyDictionary {
    @JsOverlay
    @Nonnull
    default Builder nullableObjectValue(@Nullable final Object nullableObjectValue) {
      setNullableObjectValue( nullableObjectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder objectValue(@Nonnull final Object objectValue) {
      setObjectValue( objectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredObjectValue(@Nonnull final Object requiredObjectValue) {
      setRequiredObjectValue( requiredObjectValue );
      return this;
    }
  }
}
