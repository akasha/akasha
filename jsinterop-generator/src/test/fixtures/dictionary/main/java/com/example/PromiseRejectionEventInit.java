package com.example;

import elemental2.promise.Promise;
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
    name = "?"
)
public interface PromiseRejectionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static PromiseRejectionEventInit create(@Nonnull final Promise<Any> promise) {
    return Js.<PromiseRejectionEventInit>uncheckedCast( JsPropertyMap.of() ).promise( promise );
  }

  @JsProperty(
      name = "promise"
  )
  @Nonnull
  Promise<Any> promise();

  @JsProperty
  void setPromise(@Nonnull Promise<Any> promise);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit promise(@Nonnull final Promise<Any> promise) {
    setPromise( promise );
    return this;
  }

  @JsProperty(
      name = "reason"
  )
  @Nullable
  Any reason();

  @JsProperty
  void setReason(@Nullable Any reason);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit reason(@Nullable final Any reason) {
    setReason( reason );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default PromiseRejectionEventInit bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default PromiseRejectionEventInit cancelable(final boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default PromiseRejectionEventInit composed(final boolean composed) {
    setComposed( composed );
    return this;
  }
}
