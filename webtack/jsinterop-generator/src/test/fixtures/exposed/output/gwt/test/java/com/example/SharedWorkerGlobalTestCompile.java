package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SharedWorkerGlobalTestCompile {
  public static MessageEventHandler onmessageerror() {
    return SharedWorkerGlobal.onmessageerror;
  }

  public static void onmessageerror(final MessageEventHandler value) {
    SharedWorkerGlobal.onmessageerror = value;
  }

  public static EventHandler onstuff() {
    return SharedWorkerGlobal.onstuff;
  }

  public static void onstuff(final EventHandler value) {
    SharedWorkerGlobal.onstuff = value;
  }

  public static String sharedWorkerGlobalScopeAttribute() {
    return SharedWorkerGlobal.sharedWorkerGlobalScopeAttribute();
  }

  public static int requestAnimationFrame(@DoNotAutobox final Object callback) {
    return SharedWorkerGlobal.requestAnimationFrame( callback );
  }

  public static int requestAnimationFrame2(final String callbackId) {
    return SharedWorkerGlobal.requestAnimationFrame2( callbackId );
  }

  public static String workerGlobalScopeAttribute() {
    return SharedWorkerGlobal.workerGlobalScopeAttribute();
  }
}
