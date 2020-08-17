package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

/**
 * The console object provides access to the browser's debugging console (e.g. the Web Console in Firefox). The specifics of how it works varies from browser to browser, but there is a de facto set of features that are typically provided.
 * This tests that lowercase name converted to uppercase when converted into java.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console">console - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "console"
)
public final class Console {
  private Console() {
  }

  @JsMethod(
      name = "assert"
  )
  public native void assert_(boolean condition, @Nullable Any... data);

  @JsMethod(
      name = "assert"
  )
  public native void assert_(boolean condition);

  /**
   * The console.clear() method clears the console if the environment allows it.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/clear">console.clear - MDN</a>
   */
  public native void clear();

  /**
   * Outputs a warning message to the Web Console.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/warn">console.warn - MDN</a>
   */
  public native void warn(@Nullable Any... data);
}
