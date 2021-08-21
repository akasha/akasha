package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "$wnd"
)
public final class SharedWorkerGlobal {
  private SharedWorkerGlobal() {
  }

  @JsProperty(
      name = "name"
  )
  @Nonnull
  public static native String name();

  @JsProperty(
      name = "navigator"
  )
  @Nonnull
  public static native WorkerNavigator navigator();
}
