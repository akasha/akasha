package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Callback has both return type and argument as enums.
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface SomeCallbackHandler {
  @MagicConstant(
      valuesFromClass = SpeechRecognitionErrorCode.class
  )
  @Nonnull
  String onInvoke(@MagicConstant(valuesFromClass = TxMode.class) @Nonnull String blah);
}
