package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

/**
 * Callback has both return type and argument as enums.
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface SomeCallbackHandler {
  @SpeechRecognitionErrorCode
  @Nonnull
  String onInvoke(@TxMode @Nonnull String blah);
}
