package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

/**
 * The WebAssembly JavaScript object acts as the namespace for all WebAssembly-related functionality.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly">WebAssembly - MDN</a>
 */
@Generated("org.realityforge.webtack")
public final class WebAssembly {
  private WebAssembly() {
  }

  /**
   * Return the 'WebAssembly' namespace object.
   *
   * @return the 'WebAssembly' namespace object
   */
  @Nonnull
  public static WebAssemblyNamespace namespace() {
    return Global.webAssembly();
  }
}
