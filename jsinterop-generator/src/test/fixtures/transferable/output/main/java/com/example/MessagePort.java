package com.example;

import elemental2.core.JsArray;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MessagePort"
)
public class MessagePort implements Transferable {
  protected MessagePort() {
  }

  public native void close();

  public native void postMessage(@Nullable Any message, @Nonnull JsArray<Transferable> transfer);

  public native void postMessage(@DoNotAutobox @Nullable Object message,
      @Nonnull JsArray<Transferable> transfer);

  public native void postMessage(@Nullable Any message, @Nonnull Transferable[] transfer);

  public native void postMessage(@DoNotAutobox @Nullable Object message,
      @Nonnull Transferable[] transfer);

  public native void start();
}
