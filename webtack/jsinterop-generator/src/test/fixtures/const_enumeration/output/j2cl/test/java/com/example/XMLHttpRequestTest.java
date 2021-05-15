package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class XMLHttpRequestTest {
  static XMLHttpRequest $typeReference$;

  public static int otherReadyState(final XMLHttpRequest type) {
    return type.otherReadyState;
  }

  public static void otherReadyState(final XMLHttpRequest type, final int value) {
    type.otherReadyState = value;
  }

  public static int readyState(final XMLHttpRequest type) {
    return type.readyState();
  }

  public static int getSample(final XMLHttpRequest $instance) {
    return $instance.getSample();
  }

  public static void setSample(final XMLHttpRequest $instance, final int sample) {
    $instance.setSample( sample );
  }
}
