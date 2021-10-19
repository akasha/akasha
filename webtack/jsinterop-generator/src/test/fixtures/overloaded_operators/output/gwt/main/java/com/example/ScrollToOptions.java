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
public interface ScrollToOptions {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "left"
  )
  double left();

  @JsProperty
  void setLeft(double left);

  @JsProperty(
      name = "top"
  )
  double top();

  @JsProperty
  void setTop(double top);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends ScrollToOptions {
    @JsOverlay
    @Nonnull
    default Builder left(final double left) {
      setLeft( left );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder top(final double top) {
      setTop( top );
      return this;
    }
  }
}
