package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Worker"
)
public final class Worker {
  private Worker() {
  }

  @JsOverlay
  @Nonnull
  public static Worker of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  @JsProperty(
      name = "store"
  )
  @Nonnull
  public native IDBObjectStore store();
}
