package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOptional;

/**
 * Documentation for OnActionHandler.
 * Arbitrary link to {@link com.example.SpeechRecognitionErrorCode} and {@link com.example.NodeFilter filter}.
 *
 * @see <a href="http://example.com/API/OnActionHandler">OnActionHandler - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnActionHandler {
  void onInvoke(@JsOptional @JsNullable String type);
}
