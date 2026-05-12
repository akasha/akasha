package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioNode"
)
public class AudioNode {
  protected AudioNode() {
  }

  @JsNonNull
  public native AudioNode connect(@JsNonNull AudioNode destinationNode, int output, int input);

  @JsNonNull
  public native AudioNode connect(@JsNonNull AudioNode destinationNode, int output);

  @JsNonNull
  public native AudioNode connect(@JsNonNull AudioNode destinationNode);

  public native void connect(@JsNonNull AudioParam destinationParam, int output);

  public native void connect(@JsNonNull AudioParam destinationParam);
}
