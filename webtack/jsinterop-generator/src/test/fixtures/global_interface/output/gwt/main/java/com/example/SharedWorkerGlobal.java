package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
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
  @JsNonNull
  public static native String name();

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  public static native WorkerNavigator navigator();
}
