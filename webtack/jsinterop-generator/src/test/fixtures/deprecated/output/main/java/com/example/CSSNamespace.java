package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @deprecated
 */
@Generated("org.realityforge.webtack")
@Deprecated
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "CSS"
)
public final class CSSNamespace {
  private CSSNamespace() {
  }

  /**
   * @deprecated
   */
  @Deprecated
  @Nonnull
  public native String escape(@Nonnull String ident);
}
