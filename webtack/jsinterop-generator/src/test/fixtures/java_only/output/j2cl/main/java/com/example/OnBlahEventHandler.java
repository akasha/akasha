package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNullable;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnBlahEventHandler {
  @JsNullable
  Any onInvoke(@Nonnull String event);
}
