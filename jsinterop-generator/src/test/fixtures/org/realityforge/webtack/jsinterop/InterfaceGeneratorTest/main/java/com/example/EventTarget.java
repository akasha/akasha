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
public final class EventTarget {
  public EventTarget() {
  }

  public native boolean dispatchEvent(@Nonnull Event event);
}
