package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
    name = "Object"
)
public interface SpeechRecognitionErrorEventInit {
  @JsOverlay
  @Nonnull
  static Builder create(@SpeechRecognitionErrorCode @Nonnull final String error) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).error( error );
  }

  @JsProperty(
      name = "error"
  )
  @SpeechRecognitionErrorCode
  @Nonnull
  String error();

  @JsProperty
  void setError(@SpeechRecognitionErrorCode @Nonnull String error);

  /**
   * Required attribute is an enum
   */
  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
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
