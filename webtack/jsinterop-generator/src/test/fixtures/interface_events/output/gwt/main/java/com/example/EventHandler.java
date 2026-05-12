package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

/**
 * This is event handler documentation.
 *
 * @version 1.2.3
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface EventHandler {
  void onInvoke(@JsNonNull Event event);
}
