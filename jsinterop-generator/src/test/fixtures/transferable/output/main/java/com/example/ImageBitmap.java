package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "ImageBitmap"
)
public class ImageBitmap implements Transferable {
  ImageBitmap() {
  }

  @JsProperty(
      name = "height"
  )
  public native int height();

  @JsProperty(
      name = "width"
  )
  public native int width();

  public native void close();
}
