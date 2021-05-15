package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "EventTarget"
)
public class EventTarget {
  protected EventTarget() {
  }

  public native void removeEventListener(@Nonnull String type,
      @Nonnull EventListenerOptions options);

  public native void removeEventListener(@Nonnull String type, boolean options);

  public native void removeEventListener(@Nonnull String type);
}
