package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

/**
 * Handle events of type SpeechSynthesisEvent
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface SpeechSynthesisEventHandler {
  void onInvoke(@Nonnull SpeechSynthesisEvent event);
}
