package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechSynthesisUtterance"
)
public class SpeechSynthesisUtterance extends EventTarget {
  @Nullable
  public EventHandler onend;

  @Nullable
  public SpeechSynthesisEventHandler onpause;

  @Nullable
  public EventHandler onresume;

  @Nullable
  public SpeechSynthesisEventHandler onstart;

  SpeechSynthesisUtterance() {
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    addEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final SpeechSynthesisEventListener callback) {
    addEventListener( "end", Js.cast( callback ) );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    removeEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeEndListener(@Nonnull final SpeechSynthesisEventListener callback) {
    removeEventListener( "end", Js.cast( callback ) );
  }

  @JsOverlay
  public final void addResumeListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "resume", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addResumeListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    addEventListener( "resume", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addResumeListener(@Nonnull final SpeechSynthesisEventListener callback) {
    addEventListener( "resume", Js.cast( callback ) );
  }

  @JsOverlay
  public final void removeResumeListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "resume", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeResumeListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    removeEventListener( "resume", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeResumeListener(@Nonnull final SpeechSynthesisEventListener callback) {
    removeEventListener( "resume", Js.cast( callback ) );
  }

  @JsOverlay
  public final void addStartListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "start", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addStartListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    addEventListener( "start", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addStartListener(@Nonnull final SpeechSynthesisEventListener callback) {
    addEventListener( "start", Js.cast( callback ) );
  }

  @JsOverlay
  public final void removeStartListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final EventListenerOptions options) {
    removeEventListener( "start", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeStartListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean options) {
    removeEventListener( "start", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void removeStartListener(@Nonnull final SpeechSynthesisEventListener callback) {
    removeEventListener( "start", Js.cast( callback ) );
  }
}
