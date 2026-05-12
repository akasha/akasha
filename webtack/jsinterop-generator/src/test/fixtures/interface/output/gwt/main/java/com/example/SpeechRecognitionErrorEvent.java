package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechRecognitionErrorEvent"
)
public class SpeechRecognitionErrorEvent extends Event {
  public SpeechRecognitionErrorEvent(final @JsNonNull String type) {
    super( null );
  }

  @JsProperty(
      name = "message"
  )
  @Nonnull
  public native String message();
}
