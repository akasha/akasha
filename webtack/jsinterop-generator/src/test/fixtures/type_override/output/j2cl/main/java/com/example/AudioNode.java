package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioNode"
)
public class AudioNode {
  protected AudioNode() {
  }

  @JsOverlay
  @JsNonNull
  public final AudioNode connect(@Nonnull AudioNode destinationNode, int output, int input) {
    return Js.uncheckedCast( _connect( destinationNode, output, input ) );
  }

  @JsMethod(
      name = "connect"
  )
  @JsNonNull
  private native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode, int output,
      int input);

  @JsOverlay
  @JsNonNull
  public final AudioNode connect(@Nonnull AudioNode destinationNode, int output) {
    return Js.uncheckedCast( _connect( destinationNode, output ) );
  }

  @JsMethod(
      name = "connect"
  )
  @JsNonNull
  private native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode, int output);

  @JsOverlay
  @JsNonNull
  public final AudioNode connect(@Nonnull AudioNode destinationNode) {
    return Js.uncheckedCast( _connect( destinationNode ) );
  }

  @JsMethod(
      name = "connect"
  )
  @JsNonNull
  private native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioNode destinationNode);

  @JsOverlay
  public final void connect(@Nonnull AudioParam destinationParam, int output) {
    _connect( destinationParam, output );
  }

  @JsMethod(
      name = "connect"
  )
  @JsNonNull
  private native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioParam destinationParam,
      int output);

  @JsOverlay
  public final void connect(@Nonnull AudioParam destinationParam) {
    _connect( destinationParam );
  }

  @JsMethod(
      name = "connect"
  )
  @JsNonNull
  private native AudioNodeOrUndefinedUnion _connect(@Nonnull AudioParam destinationParam);
}
