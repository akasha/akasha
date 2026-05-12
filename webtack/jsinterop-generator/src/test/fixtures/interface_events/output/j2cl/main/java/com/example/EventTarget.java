package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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

  public native void addEventListener(@JsNonNull String type, @JsNullable EventListener callback,
      @JsNonNull AddEventListenerOptions options);

  public native void addEventListener(@JsNonNull String type, @JsNullable EventListener callback,
      boolean options);

  public native void addEventListener(@JsNonNull String type, @JsNullable EventListener callback);

  public native boolean dispatchEvent(@JsNonNull Event event);

  public native void removeEventListener(@JsNonNull String type, @JsNullable EventListener callback,
      @JsNonNull EventListenerOptions options);

  public native void removeEventListener(@JsNonNull String type, @JsNullable EventListener callback,
      boolean options);

  public native void removeEventListener(@JsNonNull String type,
      @JsNullable EventListener callback);
}
