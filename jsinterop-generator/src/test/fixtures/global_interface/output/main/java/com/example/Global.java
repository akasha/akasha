package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Accessor for the global <b>globalThis</b> property also know as the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "goog.global"
)
public final class Global {
  private static GlobalWindow globalThis;

  private Global() {
  }

  /**
   * Accessor for the global <b>globalThis</b> property contains the global <i>this</i> value, which is akin to the global object.
   *
   * @return the global object
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
   */
  @JsOverlay
  @Nonnull
  public static GlobalWindow globalThis() {
    return globalThis;
  }

  public static boolean closed() {
    return globalThis().closed();
  }

  /**
   * The window.isSecureContext read-only property indicates whether a context is capable of using features that require secure contexts.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/isSecureContext">Window.isSecureContext - MDN</a>
   * @see <a href="https://w3c.github.io/webappsec-secure-contexts/">Secure Contexts</a>
   */
  public static boolean isSecureContext() {
    return globalThis().isSecureContext();
  }

  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  @Nonnull
  public static String name() {
    return globalThis().name;
  }

  public static void scroll(double x, double y) {
    globalThis().scroll(x, y);
  }

  public static void scroll(@Nonnull ScrollToOptions options) {
    globalThis().scroll(options);
  }

  public static void scroll() {
    globalThis().scroll();
  }

  @Nonnull
  public static Object get(@Nonnull String name) {
    return globalThis().get(name);
  }

  @Nonnull
  public static String id() {
    return globalThis().id;
  }

  public static boolean open() {
    return globalThis().open();
  }

  public static boolean dispatchEvent(@DoNotAutobox @Nullable Object event) {
    return globalThis().dispatchEvent(event);
  }
}
