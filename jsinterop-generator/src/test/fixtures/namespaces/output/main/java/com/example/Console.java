package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

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
