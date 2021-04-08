package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioBufferSourceNode"
)
public class AudioBufferSourceNode extends AudioScheduledSourceNode {
  protected AudioBufferSourceNode() {
  }

  public native void start(double when, double offset, double duration);

  public native void start(double when, double offset);

  public native void start(double when);

  public native void start();
}
