package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class WindowTestCompile {
  static Window $typeReference$;

  public static EventHandler onmessageerror(final Window type) {
    return type.onmessageerror;
  }

  public static void onmessageerror(final Window type, final EventHandler value) {
    type.onmessageerror = value;
  }

  public static EventHandler onstuff(final Window type) {
    return type.onstuff;
  }

  public static void onstuff(final Window type, final EventHandler value) {
    type.onstuff = value;
  }

  public static String windowAttribute(final Window type) {
    return type.windowAttribute();
  }

  public static int requestAnimationFrame(final Window $instance,
      @DoNotAutobox final Object callback) {
    return $instance.requestAnimationFrame( callback );
  }

  public static int requestAnimationFrame2(final Window $instance, final int callbackId) {
    return $instance.requestAnimationFrame2( callbackId );
  }
}
