package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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
public final class WindowGlobal {
  private WindowGlobal() {
  }

  @JsOverlay
  public static final Location location() {
    return Js.uncheckedCast( _location() );
  }

  @JsProperty(
      name = "location"
  )
  @JsNonNull
  private static native WorkerLocationOrLocationUnion _location();

  @JsOverlay
  public static final Navigator navigator() {
    return Js.uncheckedCast( _navigator() );
  }

  @JsProperty(
      name = "navigator"
  )
  @JsNonNull
  private static native WorkerNavigatorOrNavigatorUnion _navigator();

  @JsOverlay
  public static final MessageEventHandler onmessage() {
    return Js.uncheckedCast( _onmessage() );
  }

  @JsProperty(
      name = "onmessage"
  )
  @JsNullable
  private static native ExtendableMessageEventHandlerOrMessageEventHandlerUnion _onmessage();

  @JsProperty(
      name = "onmessage"
  )
  public static native void setOnmessage(@JsNullable final MessageEventHandler value);

  @JsOverlay
  public static final Window self() {
    return Js.uncheckedCast( _self() );
  }

  @JsProperty(
      name = "self"
  )
  @JsNonNull
  private static native WorkerGlobalScopeOrWindowUnion _self();
}
