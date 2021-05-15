package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface Dictionary_requiredAnyValue {
  @JsOverlay
  @Nonnull
  static Builder create(@DoNotAutobox @Nullable final Object requiredAnyValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredAnyValue( requiredAnyValue );
  }

  @JsProperty(
      name = "requiredAnyValue"
  )
  @Nullable
  Any requiredAnyValue();

  @JsProperty
  void setRequiredAnyValue(@DoNotAutobox @Nullable Object requiredAnyValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Dictionary_requiredAnyValue {
    @JsOverlay
    @Nonnull
    default Builder requiredAnyValue(@DoNotAutobox @Nullable final Object requiredAnyValue) {
      setRequiredAnyValue( requiredAnyValue );
      return this;
    }
  }
}
