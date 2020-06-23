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
public class SpeechRecognitionErrorEvent extends Event {
  public SpeechRecognitionErrorEvent(@Nonnull String type,
      @Nonnull SpeechRecognitionErrorEventInit eventInitDict) {
    super( type, eventInitDict );
  }
}
