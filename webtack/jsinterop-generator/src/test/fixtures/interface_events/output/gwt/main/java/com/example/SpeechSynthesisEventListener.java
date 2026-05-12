package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Listener for events of type SpeechSynthesisEvent
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
@FunctionalInterface
public interface SpeechSynthesisEventListener {
  /**
   * Handle event of type SpeechSynthesisEvent
   */
  void handleEvent(@Nonnull SpeechSynthesisEvent event);
}
