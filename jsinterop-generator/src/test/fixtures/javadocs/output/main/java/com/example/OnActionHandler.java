package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

/**
 * Documentation for OnActionHandler.
 *
 * @see <a href="http://example.com/API/OnActionHandler">OnActionHandler - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface OnActionHandler {
  void onInvoke(@Nonnull String type);
}
