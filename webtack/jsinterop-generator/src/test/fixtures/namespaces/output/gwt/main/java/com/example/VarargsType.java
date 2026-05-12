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
@JsType(
    isNative = true,
    name = "VarargsType",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class VarargsType {
  private VarargsType() {
  }

  public static native void myOperation1(@JsNonNull JsArray<String> tokens);

  @JsOverlay
  public static final void myOperation1(final String @JsNonNull ... tokens) {
    _myOperation1( tokens );
  }

  @JsMethod(
      name = "myOperation1"
  )
  private static native void _myOperation1(String @JsNonNull [] tokens);

  public static native void myOperation2(@JsNonNull JsArray<String> tokens1,
      @JsNonNull JsArray<String> tokens2);

  @JsOverlay
  public static final void myOperation2(final String @JsNonNull [] tokens1,
      final String @JsNonNull ... tokens2) {
    _myOperation2( tokens1, tokens2 );
  }

  @JsMethod(
      name = "myOperation2"
  )
  private static native void _myOperation2(String @JsNonNull [] tokens1,
      String @JsNonNull [] tokens2);
}
