package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SpeechRecognitionErrorEventInitTestCompile {
  static SpeechRecognitionErrorEventInit $typeReference$;

  public static SpeechRecognitionErrorEventInit.Builder create(final String error) {
    return SpeechRecognitionErrorEventInit.create( error );
  }

  public static String error(final SpeechRecognitionErrorEventInit $instance) {
    return $instance.error();
  }

  public static void setError(final SpeechRecognitionErrorEventInit $instance, String error) {
    $instance.setError( error );
  }

  public static SpeechRecognitionErrorEventInit.Builder error(
      final SpeechRecognitionErrorEventInit.Builder $instance, final String error) {
    return $instance.error( error );
  }
}
