package com.example;

import elemental2.core.JsArray;
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
    name = "?"
)
public interface PostMessageOptions {
  @JsOverlay
  @Nonnull
  static PostMessageOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "transfer"
  )
  JsArray<Object> transfer();

  @JsProperty
  void setTransfer(@Nonnull JsArray<Object> transfer);

  @JsOverlay
  @Nonnull
  default PostMessageOptions transfer(@Nonnull final JsArray<Object> transfer) {
    setTransfer( transfer );
    return this;
  }

  @JsOverlay
  default void setTransfer(@Nonnull final Object... transfer) {
    setTransfer( Js.<JsArray<Object>>uncheckedCast( transfer ) );
  }

  @JsOverlay
  @Nonnull
  default PostMessageOptions transfer(@Nonnull final Object... transfer) {
    setTransfer( transfer );
    return this;
  }
}
