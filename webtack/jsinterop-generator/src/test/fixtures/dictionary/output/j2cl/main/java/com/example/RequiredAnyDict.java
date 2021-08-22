package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
    name = "RequiredAnyDict"
)
public interface RequiredAnyDict {
  @JsOverlay
  @Nonnull
  static Builder create(@DoNotAutobox @Nullable final Object someValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).someValue( someValue );
  }

  @JsProperty(
      name = "someValue"
  )
  @JsNullable
  Any someValue();

  @JsProperty
  void setSomeValue(@DoNotAutobox @JsNullable Object someValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "RequiredAnyDict"
  )
  interface Builder extends RequiredAnyDict {
    @JsOverlay
    @Nonnull
    default Builder someValue(@DoNotAutobox @Nullable final Object someValue) {
      setSomeValue( someValue );
      return this;
    }
  }
}
