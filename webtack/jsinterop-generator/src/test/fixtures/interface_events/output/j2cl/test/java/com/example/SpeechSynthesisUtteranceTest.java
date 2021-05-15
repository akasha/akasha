package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SpeechSynthesisUtteranceTest {
  static SpeechSynthesisUtterance $typeReference$;

  public static EventHandler onend(final SpeechSynthesisUtterance type) {
    return type.onend;
  }

  public static void onend(final SpeechSynthesisUtterance type, final EventHandler value) {
    type.onend = value;
  }

  public static SpeechSynthesisEventHandler onpause(final SpeechSynthesisUtterance type) {
    return type.onpause;
  }

  public static void onpause(final SpeechSynthesisUtterance type,
      final SpeechSynthesisEventHandler value) {
    type.onpause = value;
  }

  public static EventHandler onresume(final SpeechSynthesisUtterance type) {
    return type.onresume;
  }

  public static void onresume(final SpeechSynthesisUtterance type, final EventHandler value) {
    type.onresume = value;
  }

  public static SpeechSynthesisEventHandler onstart(final SpeechSynthesisUtterance type) {
    return type.onstart;
  }

  public static void onstart(final SpeechSynthesisUtterance type,
      final SpeechSynthesisEventHandler value) {
    type.onstart = value;
  }
}
