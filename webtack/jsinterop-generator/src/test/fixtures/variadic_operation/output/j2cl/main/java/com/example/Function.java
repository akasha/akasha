package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNullable;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface Function {
  @JsNullable
  Any onInvoke(@DoNotAutobox @Nullable Object... arguments);
}
