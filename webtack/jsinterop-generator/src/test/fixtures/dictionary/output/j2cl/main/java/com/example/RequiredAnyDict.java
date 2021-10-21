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
  static RequiredAnyDict someValue(@DoNotAutobox @Nullable final Object someValue) {
    final RequiredAnyDict $requiredAnyDict = Js.<RequiredAnyDict>uncheckedCast( JsPropertyMap.of() );
    $requiredAnyDict.setSomeValue( someValue );
    return Js.uncheckedCast( $requiredAnyDict );
  }

  @JsProperty(
      name = "someValue"
  )
  @JsNullable
  Any someValue();

  @JsProperty
  void setSomeValue(@DoNotAutobox @JsNullable Object someValue);
}
