package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOptional;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnBufferSourceHandler {
  void onInvoke(@JsOptional @JsNullable BufferSource buffer);
}
