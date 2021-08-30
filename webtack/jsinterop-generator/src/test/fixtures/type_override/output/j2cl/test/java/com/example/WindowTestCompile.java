package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowTestCompile {
  static Window $typeReference$;

  public static Location location(final Window type) {
    return type.location();
  }

  public static Navigator navigator(final Window type) {
    return type.navigator();
  }

  public static MessageEventHandler onmessage(final Window type) {
    return type.onmessage;
  }

  public static void onmessage(final Window type, final MessageEventHandler value) {
    type.onmessage = value;
  }

  public static Window self(final Window type) {
    return type.self();
  }
}
