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
public final class AudioWorkletGlobal {
  private AudioWorkletGlobal() {
  }

  @JsProperty(
      name = "audioWorkletGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String audioWorkletGlobalScopeAttribute();

  @JsProperty(
      name = "workletGlobalScopeAttribute"
  )
  @JsNonNull
  public static native String workletGlobalScopeAttribute();
}
