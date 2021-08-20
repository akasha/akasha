package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface EventOrStringUnion {
  @JsOverlay
  @Nonnull
  static EventOrStringUnion of(@Nonnull final Event value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static EventOrStringUnion of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isEvent() {
    return ( (Object) this ) instanceof Event;
  }

  @JsOverlay
  default Event asEvent() {
    return Js.cast( this );
  }
}
