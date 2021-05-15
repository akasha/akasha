package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @deprecated
 */
@JsType(
    isNative = true,
    name = "CSS",
    namespace = JsPackage.GLOBAL
)
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
  public static native String escape(@Nonnull String ident);
}
