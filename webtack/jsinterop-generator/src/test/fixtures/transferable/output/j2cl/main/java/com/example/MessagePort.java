package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MessagePort"
)
public class MessagePort {
  protected MessagePort() {
  }

  public native void close();

  public native void postMessage(@DoNotAutobox java.lang. @JsNullable Object message,
      @JsNonNull JsArray<Object> transfer);

  @JsOverlay
  public final void postMessage(@DoNotAutobox final java.lang. @JsNullable Object message,
      final Object @JsNonNull ... transfer) {
    _postMessage( message, transfer );
  }

  @JsMethod(
      name = "postMessage"
  )
  private native void _postMessage(@DoNotAutobox java.lang. @JsNullable Object message,
      Object @JsNonNull [] transfer);

  public native void start();
}
