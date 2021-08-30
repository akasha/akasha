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
public interface WorkerGlobalScopeOrWindowUnion {
  @JsOverlay
  @Nonnull
  static WorkerGlobalScopeOrWindowUnion of(@Nonnull final WorkerGlobalScope value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static WorkerGlobalScopeOrWindowUnion of(@Nonnull final Window value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isWindow() {
    return ( (Object) this ) instanceof Window;
  }

  @JsOverlay
  default Window asWindow() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isWorkerGlobalScope() {
    return ( (Object) this ) instanceof WorkerGlobalScope;
  }

  @JsOverlay
  default WorkerGlobalScope asWorkerGlobalScope() {
    return Js.cast( this );
  }
}
