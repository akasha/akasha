package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "EventTarget"
)
public class EventTarget {
  public EventTarget() {
  }

  public native void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      @Nonnull AddEventListenerOptions options);

  public native void addEventListener(@Nonnull String type, @Nullable EventListener callback,
      boolean options);

  public native void addEventListener(@Nonnull String type, @Nullable EventListener callback);

  public native boolean dispatchEvent(@Nonnull Event event);

  public native void removeEventListener(@Nonnull String type, @Nullable EventListener callback,
      @Nonnull EventListenerOptions options);

  public native void removeEventListener(@Nonnull String type, @Nullable EventListener callback,
      boolean options);

  public native void removeEventListener(@Nonnull String type, @Nullable EventListener callback);
}
