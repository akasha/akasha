package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOptional;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnErrorEventHandler {
  @JsNullable
  Any onInvoke(@JsNonNull EventOrStringUnion event, @JsOptional @JsNullable String source,
      @JsOptional @JsNullable Double lineno, @JsOptional @JsNullable Double colno,
      @DoNotAutobox @JsOptional @JsNullable Object error);
}
