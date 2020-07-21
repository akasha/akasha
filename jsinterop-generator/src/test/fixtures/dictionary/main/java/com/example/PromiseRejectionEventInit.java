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
    final PromiseRejectionEventInit value = Js.uncheckedCast( JsPropertyMap.of() );
    value.setPromise( promise );
    return value;
  }

  @JsProperty
  @Nonnull
  Promise<Any> getPromise();

  @JsProperty
  void setPromise(@Nonnull Promise<Any> promise);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit promise(@Nonnull Promise<Any> promise) {
    setPromise( promise );
    return this;
  }

  @JsProperty
  @Nullable
  Any getReason();

  @JsProperty
  void setReason(@Nullable Any reason);

  @JsOverlay
  @Nonnull
  default PromiseRejectionEventInit reason(@Nullable Any reason) {
    setReason( reason );
    return this;
  }
}
