package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = SpeechRecognitionErrorCode.class
)
public @interface SpeechRecognitionErrorCode {
  @Nonnull
  String aborted = "aborted";

  @Nonnull
  String audio_capture = "audio-capture";

  @Nonnull
  String bad_grammar = "bad-grammar";

  @Nonnull
  String language_not_supported = "language-not-supported";

  @Nonnull
  String network = "network";

  @Nonnull
  String no_speech = "no-speech";

  @Nonnull
  String not_allowed = "not-allowed";

  @Nonnull
  String service_not_allowed = "service-not-allowed";
}
