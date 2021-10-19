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
  static Builder error(@SpeechRecognitionErrorCode @Nonnull final String error) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).error( error );
  }

  @JsProperty(
      name = "error"
  )
  @SpeechRecognitionErrorCode
  @JsNonNull
  String error();

  @JsProperty
  void setError(@SpeechRecognitionErrorCode @JsNonNull String error);

  /**
   * Required attribute is an enum
   */
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "SpeechRecognitionErrorEventInit"
  )
  interface Builder extends SpeechRecognitionErrorEventInit {
    @JsOverlay
    @Nonnull
    default Builder error(@SpeechRecognitionErrorCode @Nonnull final String error) {
      setError( error );
      return this;
    }
  }
}
