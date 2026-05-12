package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The console object provides access to the browser's debugging console (e.g. the Web Console in Firefox). The specifics of how it works varies from browser to browser, but there is a de facto set of features that are typically provided.
 * This tests that lowercase name converted to uppercase when converted into java.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console">console - MDN</a>
 */
@JsType(
    isNative = true,
    name = "console",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class Console {
  private Console() {
  }

  @JsMethod(
      name = "assert"
  )
  public static native void assert_(boolean condition, @DoNotAutobox @JsNullable Object... data);

  @JsMethod(
      name = "assert"
  )
  public static native void assert_(boolean condition);

  /**
   * The console.clear() method clears the console if the environment allows it.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/clear">console.clear - MDN</a>
   */
  public static native void clear();

  /**
   * Last argument is optional and a varargs candidate
   */
  public static native void table(@DoNotAutobox @JsNullable Object tabularData,
      @JsNonNull JsArray<String> properties);

  /**
   * Last argument is optional and a varargs candidate
   */
  @JsOverlay
  public static final void table(@DoNotAutobox final @JsNullable Object tabularData,
      final String @JsNonNull ... properties) {
    _table( tabularData, properties );
  }

  @JsMethod(
      name = "table"
  )
  private static native void _table(@DoNotAutobox @JsNullable Object tabularData,
      String @JsNonNull [] properties);

  /**
   * Last argument is optional and a varargs candidate
   */
  public static native void table(@DoNotAutobox @JsNullable Object tabularData);

  /**
   * Last argument is optional and a varargs candidate
   */
  public static native void table();

  /**
   * Outputs a warning message to the Web Console.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/warn">console.warn - MDN</a>
   */
  public static native void warn(@DoNotAutobox @JsNullable Object... data);
}
