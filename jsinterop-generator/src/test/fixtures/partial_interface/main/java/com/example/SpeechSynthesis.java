package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechSynthesis"
)
public class SpeechSynthesis {
  SpeechSynthesis() {
  }

  @JsProperty(
      name = "paused"
  )
  public native boolean paused();

  @JsProperty(
      name = "pending"
  )
  public native boolean pending();

  @JsProperty(
      name = "speaking"
  )
  public native boolean speaking();
}
