package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MessagePortTest {
  public static void close(final MessagePort $instance) {
    $instance.close();
  }

  public static void postMessage(final MessagePort $instance, @DoNotAutobox final Object message,
      final JsArray<Object> transfer) {
    $instance.postMessage( message, transfer );
  }

  public static void postMessage(final MessagePort $instance, @DoNotAutobox final Object message,
      final Object[] transfer) {
    $instance.postMessage( message, transfer );
  }

  public static void start(final MessagePort $instance) {
    $instance.start();
  }
}
