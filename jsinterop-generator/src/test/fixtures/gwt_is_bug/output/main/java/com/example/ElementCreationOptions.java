package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public interface ElementCreationOptions {
  @JsOverlay
  @Nonnull
  static ElementCreationOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "is"
  )
  String _is();

  @JsProperty
  void setIs(@Nonnull String is);

  @JsOverlay
  @Nonnull
  default ElementCreationOptions is(@Nonnull final String is) {
    setIs( is );
    return this;
  }
}
