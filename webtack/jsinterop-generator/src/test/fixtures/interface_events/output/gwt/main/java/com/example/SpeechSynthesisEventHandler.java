package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

/**
 * Handle events of type SpeechSynthesisEvent
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface SpeechSynthesisEventHandler {
  void onInvoke(@JsNonNull SpeechSynthesisEvent event);
}
