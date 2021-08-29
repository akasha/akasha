package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  public native AudioNode connect(@Nonnull AudioNode destinationNode, int output, int input);

  @JsNonNull
  public native AudioNode connect(@Nonnull AudioNode destinationNode, int output);

  @JsNonNull
  public native AudioNode connect(@Nonnull AudioNode destinationNode);

  public native void connect(@Nonnull AudioParam destinationParam, int output);

  public native void connect(@Nonnull AudioParam destinationParam);
}
