package com.biz;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * This is a predefined type.
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "CSS" )
public final class MyCSS
{
  private MyCSS()
  {
  }

  @Nonnull
  public native String escape( @Nonnull String ident );
}
