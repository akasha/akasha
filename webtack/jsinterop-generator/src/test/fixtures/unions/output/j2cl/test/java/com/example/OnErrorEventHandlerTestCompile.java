package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class OnErrorEventHandlerTestCompile {
  static OnErrorEventHandler $typeReference$;

  public static Any onInvoke(final OnErrorEventHandler $instance, final EventOrStringUnion event,
      final String source, final Double lineno, final Double colno,
      @DoNotAutobox final Object error) {
    return $instance.onInvoke( event, source, lineno, colno, error );
  }
}
