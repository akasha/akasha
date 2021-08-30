package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.jetbrains.annotations.ApiStatus;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "AudioNodeOrUndefinedUnion"
)
@ApiStatus.Internal
interface AudioNodeOrUndefinedUnion {
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
  default boolean isAudioNode() {
    return ( (Object) this ) instanceof AudioNode;
  }

  @JsOverlay
  default AudioNode asAudioNode() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isVoid() {
    return Js.isTripleEqual( Js.undefined(), this );
  }
}
