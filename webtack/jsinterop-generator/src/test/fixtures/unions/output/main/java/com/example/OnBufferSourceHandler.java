package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOptional;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnBufferSourceHandler {
  void onInvoke(@Nonnull @JsOptional BufferSource buffer);
}
