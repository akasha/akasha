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
public interface OptionalAnyDict extends RequiredAnyDict {
  @JsOverlay
  @Nonnull
  static OptionalAnyDict create(@DoNotAutobox @Nullable final Object someValue) {
    return Js.<OptionalAnyDict>uncheckedCast( JsPropertyMap.of() ).someValue( someValue );
  }

  @JsProperty(
      name = "anotherValue"
  )
  @Nullable
  Any anotherValue();

  @JsProperty
  void setAnotherValue(@DoNotAutobox @Nullable Object anotherValue);

  @JsOverlay
  @Nonnull
  default OptionalAnyDict anotherValue(@DoNotAutobox @Nullable final Object anotherValue) {
    setAnotherValue( anotherValue );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default OptionalAnyDict someValue(@DoNotAutobox @Nullable final Object someValue) {
    setSomeValue( someValue );
    return this;
  }
}
