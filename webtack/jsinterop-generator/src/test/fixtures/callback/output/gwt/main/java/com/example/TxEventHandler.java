package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOptional;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface TxEventHandler {
  void onInvoke(@JsNonNull Event event, @JsOptional @JsNullable String source,
      @JsOptional @JsNullable CallbackOptions metadata);
}
