package com.biz;

import com.biz.MyIDBIndex;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * This is a predefined type.
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Window" )
public final class MyWindow
{
  private MyWindow()
  {
  }

  @JsOverlay
  @Nonnull
  public static MyWindow of( @Nonnull final Object object )
  {
    return Js.cast( object );
  }

  @JsProperty(
    name = "index"
  )
  @Nonnull
  public native MyIDBIndex index();
}
