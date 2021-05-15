package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

  public native void postMessage(@DoNotAutobox @Nullable java.lang.Object message,
      @Nonnull JsArray<Object> transfer);

  public native void postMessage(@DoNotAutobox @Nullable java.lang.Object message,
      @Nonnull Object[] transfer);

  public native void start();
}
