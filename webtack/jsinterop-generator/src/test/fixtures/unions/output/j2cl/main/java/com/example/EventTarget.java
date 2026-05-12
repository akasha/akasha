package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
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

  public native void removeEventListener(@JsNonNull String type,
      @JsNonNull EventListenerOptions options);

  public native void removeEventListener(@JsNonNull String type, boolean options);

  public native void removeEventListener(@JsNonNull String type);
}
