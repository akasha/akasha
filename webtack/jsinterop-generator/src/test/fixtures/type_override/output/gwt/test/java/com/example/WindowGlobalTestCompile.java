package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTestCompile {
  public static Location location() {
    return WindowGlobal.location();
  }

  public static Navigator navigator() {
    return WindowGlobal.navigator();
  }

  public static MessageEventHandler onmessage() {
    return WindowGlobal.onmessage;
  }

  public static void onmessage(final MessageEventHandler value) {
    WindowGlobal.onmessage = value;
  }

  public static Window self() {
    return WindowGlobal.self();
  }
}
