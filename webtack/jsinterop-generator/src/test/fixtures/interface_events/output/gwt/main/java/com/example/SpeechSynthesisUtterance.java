package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNullable;
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
  @JsNullable
  public EventHandler onend;

  @JsNullable
  public SpeechSynthesisEventHandler onpause;

  @JsNullable
  public EventHandler onresume;

  @JsNullable
  public SpeechSynthesisEventHandler onstart;

  protected SpeechSynthesisUtterance() {
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      @Nonnull final AddEventListenerOptions options) {
    addEventListener( "end", Js.cast( callback ), options );
  }

  @JsOverlay
  public final void addEndListener(@Nonnull final SpeechSynthesisEventListener callback,
      final boolean useCapture) {
    addEventListener( "end", Js.cast( callback ), useCapture );
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
      final boolean useCapture) {
    removeEventListener( "end", Js.cast( callback ), useCapture );
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
      final boolean useCapture) {
    addEventListener( "resume", Js.cast( callback ), useCapture );
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
      final boolean useCapture) {
    removeEventListener( "resume", Js.cast( callback ), useCapture );
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
      final boolean useCapture) {
    addEventListener( "start", Js.cast( callback ), useCapture );
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
      final boolean useCapture) {
    removeEventListener( "start", Js.cast( callback ), useCapture );
  }

  @JsOverlay
  public final void removeStartListener(@Nonnull final SpeechSynthesisEventListener callback) {
    removeEventListener( "start", Js.cast( callback ) );
  }
}
