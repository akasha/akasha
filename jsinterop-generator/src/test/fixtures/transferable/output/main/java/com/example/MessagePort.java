package com.example;

import elemental2.core.JsArray;
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

  public native void postMessage(@DoNotAutobox @Nullable Object message,
      @Nonnull JsArray<Object> transfer);

  public native void postMessage(@DoNotAutobox @Nullable Object message,
      @Nonnull Object[] transfer);

  public native void start();
}
