package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechRecognitionErrorEvent"
)
public final class SpeechRecognitionErrorEvent extends Event {
  @Nonnull
  public final String message;

  public SpeechRecognitionErrorEvent(@Nonnull final String type) {
    super( type );
    // Initialize read-only attributes. This is done to satisfy the JVM and will be ignored when transpiled to javascript.
    this.message = null;
  }
}
