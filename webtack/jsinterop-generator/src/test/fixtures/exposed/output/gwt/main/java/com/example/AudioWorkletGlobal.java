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
public final class AudioWorkletGlobal {
  private AudioWorkletGlobal() {
  }

  @JsProperty(
      name = "audioWorkletGlobalScopeAttribute"
  )
  @Nonnull
  public static native String audioWorkletGlobalScopeAttribute();

  @JsProperty(
      name = "workletGlobalScopeAttribute"
  )
  @Nonnull
  public static native String workletGlobalScopeAttribute();
}
