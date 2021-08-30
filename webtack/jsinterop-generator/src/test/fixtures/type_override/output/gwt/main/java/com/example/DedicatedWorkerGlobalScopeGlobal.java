package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
)
public final class DedicatedWorkerGlobalScopeGlobal {
  private DedicatedWorkerGlobalScopeGlobal() {
  }

  @JsProperty(
      name = "location"
  )
  @JsNonNull
  public static native WorkerLocation location();

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  public static native WorkerNavigator navigator();

  @JsProperty(
      name = "self"
  )
  @JsNonNull
  public static native WorkerGlobalScope self();
}
