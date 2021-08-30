package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class DedicatedWorkerGlobalScopeGlobal {
  private DedicatedWorkerGlobalScopeGlobal() {
  }

  @JsOverlay
  public static final WorkerLocation location() {
    return Js.uncheckedCast( _location() );
  }

  @JsProperty(
      name = "location"
  )
  @JsNonNull
  private static native WorkerLocationOrLocationUnion _location();

  @JsOverlay
  public static final WorkerNavigator navigator() {
    return Js.uncheckedCast( _navigator() );
  }

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  private static native WorkerNavigatorOrNavigatorUnion _navigator();

  @JsOverlay
  public static final WorkerGlobalScope self() {
    return Js.uncheckedCast( _self() );
  }

  @JsProperty(
      name = "self"
  )
  @JsNonNull
  private static native WorkerGlobalScopeOrWindowUnion _self();
}
