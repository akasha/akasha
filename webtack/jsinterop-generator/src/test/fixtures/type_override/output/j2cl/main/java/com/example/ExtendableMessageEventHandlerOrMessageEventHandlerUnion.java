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
    name = "ExtendableMessageEventHandlerOrMessageEventHandlerUnion"
)
public interface ExtendableMessageEventHandlerOrMessageEventHandlerUnion {
  @JsOverlay
  @Nonnull
  static ExtendableMessageEventHandlerOrMessageEventHandlerUnion of(
      @Nonnull final ExtendableMessageEventHandler value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ExtendableMessageEventHandlerOrMessageEventHandlerUnion of(
      @Nonnull final MessageEventHandler value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isExtendableMessageEventHandler() {
    return ( (Object) this ) instanceof ExtendableMessageEventHandler;
  }

  @JsOverlay
  default ExtendableMessageEventHandler asExtendableMessageEventHandler() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isMessageEventHandler() {
    return ( (Object) this ) instanceof MessageEventHandler;
  }

  @JsOverlay
  default MessageEventHandler asMessageEventHandler() {
    return Js.cast( this );
  }
}
