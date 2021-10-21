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
    name = "OptionalAnyDict"
)
public interface OptionalAnyDict extends RequiredAnyDict {
  @JsOverlay
  @Nonnull
  static OptionalAnyDict someValue(@DoNotAutobox @Nullable final Object someValue) {
    final OptionalAnyDict $optionalAnyDict = Js.<OptionalAnyDict>uncheckedCast( JsPropertyMap.of() );
    $optionalAnyDict.setSomeValue( someValue );
    return Js.uncheckedCast( $optionalAnyDict );
  }

  @JsProperty(
      name = "anotherValue"
  )
  @JsNullable
  Any anotherValue();

  @JsProperty
  void setAnotherValue(@DoNotAutobox @JsNullable Object anotherValue);
}
