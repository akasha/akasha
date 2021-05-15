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
    name = "MyDictionary"
)
public interface MyDictionary {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsObject requiredObjectValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredObjectValue( requiredObjectValue );
  }

  @JsProperty(
      name = "nullableObjectValue"
  )
  @Nullable
  JsObject nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@Nullable JsObject nullableObjectValue);

  @JsProperty(
      name = "objectValue"
  )
  JsObject objectValue();

  @JsProperty
  void setObjectValue(@Nonnull JsObject objectValue);

  @JsProperty(
      name = "requiredObjectValue"
  )
  @Nonnull
  JsObject requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@Nonnull JsObject requiredObjectValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "MyDictionary"
  )
  interface Builder extends MyDictionary {
    @JsOverlay
    @Nonnull
    default Builder nullableObjectValue(@Nullable final JsObject nullableObjectValue) {
      setNullableObjectValue( nullableObjectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder objectValue(@Nonnull final JsObject objectValue) {
      setObjectValue( objectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredObjectValue(@Nonnull final JsObject requiredObjectValue) {
      setRequiredObjectValue( requiredObjectValue );
      return this;
    }
  }
}
