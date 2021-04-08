package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioScheduledSourceNode"
)
public class AudioScheduledSourceNode {
  protected AudioScheduledSourceNode() {
  }

  public native void start(double when);

  public native void start();

  public native void stop(double when);

  public native void stop();
}
