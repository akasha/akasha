package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Documentation for NodeFilter.
 *
 * @see <a href="http://example.com/API/NodeFilter">NodeFilter - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "NodeFilter"
)
@FunctionalInterface
public interface NodeFilter {
  /**
   * Documentation for FILTER_ACCEPT.
   *
   * @see <a href="http://example.com/API/NodeFilter/FILTER_ACCEPT">NodeFilter.FILTER_ACCEPT - MDN</a>
   */
  @JsOverlay
  int FILTER_ACCEPT = 1;

  /**
   * Documentation for acceptNode.
   *
   * @return the code.
   * @see <a href="http://example.com/API/NodeFilter/acceptNode">NodeFilter.acceptNode - MDN</a>
   */
  int acceptNode(@Nonnull Node node);
}
