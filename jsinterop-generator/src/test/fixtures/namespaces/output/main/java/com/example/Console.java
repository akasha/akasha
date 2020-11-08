package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The console object provides access to the browser's debugging console (e.g. the Web Console in Firefox). The specifics of how it works varies from browser to browser, but there is a de facto set of features that are typically provided.
 * This tests that lowercase name converted to uppercase when converted into java.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console">console - MDN</a>
 */
@Generated("org.realityforge.webtack")
public final class Console {
  private Console() {
  }

  public static void assert_(boolean condition, @DoNotAutobox @Nullable Object... data) {
    namespace().assert_(condition, data);
  }

  public static void assert_(boolean condition) {
    namespace().assert_(condition);
  }

  /**
   * The console.clear() method clears the console if the environment allows it.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/clear">console.clear - MDN</a>
   */
  public static void clear() {
    namespace().clear();
  }

  /**
   * Outputs a warning message to the Web Console.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/warn">console.warn - MDN</a>
   */
  public static void warn(@DoNotAutobox @Nullable Object... data) {
    namespace().warn(data);
  }

  /**
   * Return the 'console' namespace object.
   *
   * @return the 'console' namespace object
   */
  @Nonnull
  public static ConsoleNamespace namespace() {
    return Global.console();
  }
}
