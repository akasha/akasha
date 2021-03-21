package com.biz;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
public interface MyStringOrLongLongUnion
{
  @JsOverlay
  @Nonnull
  static MyStringOrLongLongUnion of( @Nonnull final String value )
  {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static MyStringOrLongLongUnion of( final int value )
  {
    return Js.cast( value );
  }
}
