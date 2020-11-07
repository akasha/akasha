package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public final class GlobalWindow extends Window {
  private GlobalWindow() {
  }

  @JsProperty(
      name = "console"
  )
  @Nonnull
  public native ConsoleNamespace console();

  @JsProperty(
      name = "CSS"
  )
  @Nonnull
  public native CSSNamespace css();

  @JsProperty(
      name = "WebAssembly"
  )
  @Nonnull
  public native WebAssemblyNamespace webAssembly();
}
