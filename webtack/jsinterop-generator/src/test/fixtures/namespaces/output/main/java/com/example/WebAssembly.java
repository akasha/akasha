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
   * The WebAssembly.validate() function validates a given typed array of WebAssembly binary code, returning whether the bytes form a valid wasm module (true) or not (false).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/validate">WebAssembly.validate - MDN</a>
   */
  public static boolean validate(@Nonnull ArrayBuffer bytes) {
    return namespace().validate(bytes);
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
