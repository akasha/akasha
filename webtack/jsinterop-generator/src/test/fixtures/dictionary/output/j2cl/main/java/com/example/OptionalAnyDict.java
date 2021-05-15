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
    name = "OptionalAnyDict"
)
public interface OptionalAnyDict extends RequiredAnyDict {
  @JsOverlay
  @Nonnull
  static Builder create(@DoNotAutobox @Nullable final Object someValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).someValue( someValue );
  }

  @JsProperty(
      name = "anotherValue"
  )
  @Nullable
  Any anotherValue();

  @JsProperty
  void setAnotherValue(@DoNotAutobox @Nullable Object anotherValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "OptionalAnyDict"
  )
  interface Builder extends OptionalAnyDict {
    @JsOverlay
    @Nonnull
    default Builder anotherValue(@DoNotAutobox @Nullable final Object anotherValue) {
      setAnotherValue( anotherValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someValue(@DoNotAutobox @Nullable final Object someValue) {
      setSomeValue( someValue );
      return this;
    }
  }
}
