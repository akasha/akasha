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
  public EventTarget() {
  }

  public native boolean dispatchEvent(@JsNonNull Event event);
}
