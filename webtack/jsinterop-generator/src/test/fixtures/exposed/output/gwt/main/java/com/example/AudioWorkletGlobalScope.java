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
    name = "AudioWorkletGlobalScope"
)
public class AudioWorkletGlobalScope extends WorkletGlobalScope {
  protected AudioWorkletGlobalScope() {
  }

  @JsProperty(
      name = "audioWorkletGlobalScopeAttribute"
  )
  @Nonnull
  public native String audioWorkletGlobalScopeAttribute();
}
