package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

/**
 * This is event handler documentation.
 *
 * @version 1.2.3
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface EventHandler {
  void onInvoke(@Nonnull Event event);
}
