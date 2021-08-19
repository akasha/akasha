package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SharedWorkerGlobalScopeTestCompile {
  static SharedWorkerGlobalScope $typeReference$;

  public static MessageEventHandler onmessageerror(final SharedWorkerGlobalScope type) {
    return type.onmessageerror;
  }

  public static void onmessageerror(final SharedWorkerGlobalScope type,
      final MessageEventHandler value) {
    type.onmessageerror = value;
  }

  public static EventHandler onstuff(final SharedWorkerGlobalScope type) {
    return type.onstuff;
  }

  public static void onstuff(final SharedWorkerGlobalScope type, final EventHandler value) {
    type.onstuff = value;
  }

  public static String sharedWorkerGlobalScopeAttribute(final SharedWorkerGlobalScope type) {
    return type.sharedWorkerGlobalScopeAttribute();
  }

  public static int requestAnimationFrame(final SharedWorkerGlobalScope $instance,
      @DoNotAutobox final Object callback) {
    return $instance.requestAnimationFrame( callback );
  }

  public static int requestAnimationFrame2(final SharedWorkerGlobalScope $instance,
      final String callbackId) {
    return $instance.requestAnimationFrame2( callbackId );
  }
}
