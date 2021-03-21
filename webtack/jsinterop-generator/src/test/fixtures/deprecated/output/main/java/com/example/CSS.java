package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

/**
 * @deprecated
 */
@Generated("org.realityforge.webtack")
@Deprecated
public final class CSS {
  private CSS() {
  }

  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public static String escape(@Nonnull String ident) {
    return namespace().escape(ident);
  }

  /**
   * Return the 'CSS' namespace object.
   *
   * @return the 'CSS' namespace object
   */
  @Nonnull
  @Deprecated
  public static CSSNamespace namespace() {
    return Global.css();
  }
}
