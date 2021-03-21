package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;

/**
 * Pass an element instance from the renderer.
 */
@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public abstract interface RefCallback<T> {
  /**
   * Passes the reference to the component instance or element.
   * The reference is nonnull when the element has been attached to the DOM and
   * null when the reference has been detached from the DOM.
   *
   * @param reference the reference.
   */
  void accept(@Nullable T reference);
}
