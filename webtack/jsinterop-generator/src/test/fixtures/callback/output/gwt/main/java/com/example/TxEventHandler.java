package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface TxEventHandler {
  void onInvoke(@Nonnull Event event);
}
