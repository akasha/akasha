package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "ElementCreationOptions"
)
public interface ElementCreationOptions {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "is"
  )
  String _is();

  @JsProperty
  void setIs(@JsNonNull String is);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "ElementCreationOptions"
  )
  interface Builder extends ElementCreationOptions {
    @JsOverlay
    @Nonnull
    default Builder is(@Nonnull final String is) {
      setIs( is );
      return this;
    }
  }
}
