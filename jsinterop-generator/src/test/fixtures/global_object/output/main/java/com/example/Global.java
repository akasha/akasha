package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.base.Js;

/**
 * Accessor for the global <b>globalThis</b> property also know as the global object.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/globalThis">globalThis - MDN</a>
 */
@Generated("org.realityforge.webtack")
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
  @Nonnull
  public static GlobalWindow globalThis() {
    return Js.uncheckedCast( Js.global() );
  }

  public static boolean isSecureContext() {
    return globalThis().isSecureContext();
  }

  @Nonnull
  public static String name() {
    return globalThis().name;
  }

  @Nonnull
  public static String decodeURI(@Nonnull String encodedURI) {
    return globalThis().decodeURI(encodedURI);
  }

  @Nonnull
  public static String decodeURIComponent(@Nonnull String encodedURI) {
    return globalThis().decodeURIComponent(encodedURI);
  }

  @Nonnull
  public static String encodeURI(@Nonnull String uri) {
    return globalThis().encodeURI(uri);
  }
}
