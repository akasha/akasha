package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnErrorEventHandler {
  @Nullable
  Any onInvoke(@Nonnull EventOrStringUnion event, @Nonnull String source, int lineno, int colno,
      @DoNotAutobox @Nullable Object error);
}
