package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOptional;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnErrorEventHandler {
  @Nullable
  Any onInvoke(@Nonnull EventOrStringUnion event, @Nonnull @JsOptional String source,
      @Nonnull @JsOptional Double lineno, @Nonnull @JsOptional Double colno,
      @DoNotAutobox @Nullable @JsOptional Object error);
}
