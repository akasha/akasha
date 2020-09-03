package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The global <b>globalThis</b> property or the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class Global extends Window {
  private static Global globalThis;

  private Global() {
  }

  @JsProperty(
      name = "console"
  )
  @Nonnull
  public native Console console();

  @JsProperty(
      name = "CSS"
  )
  @Nonnull
  public native CSS css();

  @JsProperty(
      name = "WebAssembly"
  )
  @Nonnull
  public native WebAssembly webAssembly();

  /**
   * Accessor for the global <b>globalThis</b> property contains the global <i>this</i> value, which is akin to the global object.
   *
   * @return the global object
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
   */
  @JsOverlay
  @Nonnull
  public static Global globalThis() {
    return globalThis;
  }
}
