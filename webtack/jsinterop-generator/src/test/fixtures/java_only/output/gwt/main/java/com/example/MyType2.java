package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyType2"
)
public class MyType2 {
  @JsOverlay
  public static final int QUERY_COUNTER_BITS_EXT = 0x8864;

  protected MyType2() {
  }

  @JsProperty(
      name = "valueB"
  )
  @Nullable
  public native Any valueB();

  public native void endQueryEXT(int target);
}
