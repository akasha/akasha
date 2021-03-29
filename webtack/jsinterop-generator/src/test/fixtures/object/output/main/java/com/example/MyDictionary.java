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
  static MyDictionary create(@Nonnull final Object requiredObjectValue) {
    return Js.<MyDictionary>uncheckedCast( JsPropertyMap.of() ).requiredObjectValue( requiredObjectValue );
  }

  @JsProperty(
      name = "nullableObjectValue"
  )
  @Nullable
  Object nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@Nullable Object nullableObjectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableObjectValue(@Nullable final Object nullableObjectValue) {
    setNullableObjectValue( nullableObjectValue );
    return this;
  }

  @JsProperty(
      name = "objectValue"
  )
  Object objectValue();

  @JsProperty
  void setObjectValue(@Nonnull Object objectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary objectValue(@Nonnull final Object objectValue) {
    setObjectValue( objectValue );
    return this;
  }

  @JsProperty(
      name = "requiredObjectValue"
  )
  @Nonnull
  Object requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@Nonnull Object requiredObjectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary requiredObjectValue(@Nonnull final Object requiredObjectValue) {
    setRequiredObjectValue( requiredObjectValue );
    return this;
  }
}
