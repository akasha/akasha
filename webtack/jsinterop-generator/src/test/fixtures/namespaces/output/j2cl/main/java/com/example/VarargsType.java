package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
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

  public static native void myOperation1(@Nonnull JsArray<String> tokens);

  @JsOverlay
  public static final void myOperation1(@Nonnull final String... tokens) {
    _myOperation1( tokens );
  }

  @JsMethod(
      name = "myOperation1"
  )
  private static native void _myOperation1(@Nonnull String[] tokens);

  public static native void myOperation2(@Nonnull JsArray<String> tokens1,
      @Nonnull JsArray<String> tokens2);

  public static native void myOperation2(@Nonnull String[] tokens1,
      @Nonnull JsArray<String> tokens2);

  @JsOverlay
  public static final void myOperation2(@Nonnull final JsArray<String> tokens1,
      @Nonnull final String... tokens2) {
    _myOperation2( tokens1, tokens2 );
  }

  @JsMethod(
      name = "myOperation2"
  )
  private static native void _myOperation2(@Nonnull JsArray<String> tokens1,
      @Nonnull String[] tokens2);

  @JsOverlay
  public static final void myOperation2(@Nonnull final String[] tokens1,
      @Nonnull final String... tokens2) {
    _myOperation2( tokens1, tokens2 );
  }

  @JsMethod(
      name = "myOperation2"
  )
  private static native void _myOperation2(@Nonnull String[] tokens1, @Nonnull String[] tokens2);
}
