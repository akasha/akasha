package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * Required attribute is an enum
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SpeechRecognitionErrorEventInit"
)
public interface SpeechRecognitionErrorEventInit {
  @JsOverlay
  @Nonnull
  static SpeechRecognitionErrorEventInit error(
      @SpeechRecognitionErrorCode @Nonnull final String error) {
    final SpeechRecognitionErrorEventInit $speechRecognitionErrorEventInit = Js.<SpeechRecognitionErrorEventInit>uncheckedCast( JsPropertyMap.of() );
    $speechRecognitionErrorEventInit.setError( error );
    return Js.uncheckedCast( $speechRecognitionErrorEventInit );
  }

  @JsProperty(
      name = "error"
  )
  @SpeechRecognitionErrorCode
  @JsNonNull
  String error();

  @JsProperty
  void setError(@SpeechRecognitionErrorCode @JsNonNull String error);
}
