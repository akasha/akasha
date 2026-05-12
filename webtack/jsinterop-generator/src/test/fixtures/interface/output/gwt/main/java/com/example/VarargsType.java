package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * This tests auto convert to varargs in jsinterop binding.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "VarargsType"
)
public class VarargsType {
  protected VarargsType() {
  }

  public static native void myOperation1(@JsNonNull JsArray<String> tokens);

  public static native void myOperation1(String @JsNonNull [] tokens);

  public native void myOperation2(@JsNonNull JsArray<String> tokens);

  @JsOverlay
  public final void myOperation2(final String @JsNonNull ... tokens) {
    _myOperation2( tokens );
  }

  @JsMethod(
      name = "myOperation2"
  )
  private native void _myOperation2(String @JsNonNull [] tokens);
}
