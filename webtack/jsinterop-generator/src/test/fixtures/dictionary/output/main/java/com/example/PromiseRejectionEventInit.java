package com.example;

import javaemul.internal.annotations.DoNotAutobox;
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
    name = "Object"
)
public interface PromiseRejectionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static PromiseRejectionEventInit create(@Nonnull final JsPromise<Any> promise) {
    return Js.<PromiseRejectionEventInit>uncheckedCast( JsPropertyMap.of() ).promise( promise );
  }

  @JsProperty(
      name = "promise"
  )
  @Nonnull
  JsPromise<Any> promise();

  @JsProperty
  void setPromise(@Nonnull JsPromise<Any> promise);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit promise(@Nonnull final JsPromise<Any> promise) {
    setPromise( promise );
    return this;
  }

  @JsProperty(
      name = "reason"
  )
  @Nullable
  Any reason();

  @JsProperty
  void setReason(@DoNotAutobox @Nullable Object reason);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit reason(@DoNotAutobox @Nullable final Object reason) {
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
