package com.example;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Event"
)
public class Event {
  public static final int AT_TARGET = 2;

  public static final int BUBBLING_PHASE = 3;

  public static final int CAPTURING_PHASE = 1;

  public static final int NONE = 0;

  public Event(@Nonnull String type, @Nonnull EventInit eventInitDict) {
  }

  public Event(@Nonnull String type) {
  }

  @Nonnull
  public native JsArray<EventTarget> composedPath();

  public native void initEvent(@Nonnull String type, boolean bubbles, boolean cancelable);

  public native void initEvent(@Nonnull String type, boolean bubbles);

  public native void initEvent(@Nonnull String type);

  public native void preventDefault();

  public native void stopImmediatePropagation();

  public native void stopPropagation();
}
