package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class CSS {
  private CSS() {
  }

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
  public static CSSNamespace namespace() {
    return Global.css();
  }
}
