package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowGlobalTestCompile {
  public static EventHandler onmessageerror() {
    return WindowGlobal.onmessageerror;
  }

  public static void onmessageerror(final EventHandler value) {
    WindowGlobal.onmessageerror = value;
  }

  public static EventHandler onstuff() {
    return WindowGlobal.onstuff;
  }

  public static void onstuff(final EventHandler value) {
    WindowGlobal.onstuff = value;
  }

  public static String windowAttribute() {
    return WindowGlobal.windowAttribute();
  }

  public static int requestAnimationFrame(@DoNotAutobox final Object callback) {
    return WindowGlobal.requestAnimationFrame( callback );
  }

  public static int requestAnimationFrame2(final int callbackId) {
    return WindowGlobal.requestAnimationFrame2( callbackId );
  }
}
