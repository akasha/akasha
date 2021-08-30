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
    name = "WorkerLocationOrLocationUnion"
)
public interface WorkerLocationOrLocationUnion {
  @JsOverlay
  @Nonnull
  static WorkerLocationOrLocationUnion of(@Nonnull final WorkerLocation value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static WorkerLocationOrLocationUnion of(@Nonnull final Location value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isLocation() {
    return ( (Object) this ) instanceof Location;
  }

  @JsOverlay
  default Location asLocation() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isWorkerLocation() {
    return ( (Object) this ) instanceof WorkerLocation;
  }

  @JsOverlay
  default WorkerLocation asWorkerLocation() {
    return Js.cast( this );
  }
}
