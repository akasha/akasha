package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "EventTarget"
)
public class EventTarget {
  @Nonnull
  public String id;

  protected EventTarget() {
  }

  @JsProperty(
      name = "open"
  )
  public native boolean open();

  public native boolean dispatchEvent(@DoNotAutobox @Nullable Object event);
}
