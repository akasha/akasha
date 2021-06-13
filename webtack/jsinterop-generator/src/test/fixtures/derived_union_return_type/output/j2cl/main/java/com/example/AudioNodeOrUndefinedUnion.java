package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioNodeOrUndefinedUnion"
)
public interface AudioNodeOrUndefinedUnion {
  @JsOverlay
  @Nonnull
  static AudioNodeOrUndefinedUnion of(@Nonnull final AudioNode value) {
    return Js.cast( value );
  }

  @JsOverlay
  static AudioNodeOrUndefinedUnion of() {
    return Js.cast( Js.undefined() );
  }

  @JsOverlay
  default AudioNode asAudioNode() {
    return Js.cast( this );
  }
}