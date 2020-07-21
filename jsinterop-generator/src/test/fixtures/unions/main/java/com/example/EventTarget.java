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
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  EventTarget() {
  }

  public native void removeEventListener(@Nonnull String type,
      @Nonnull EventListenerOptions options);

  public native void removeEventListener(@Nonnull String type, boolean options);

  public native void removeEventListener(@Nonnull String type);
}
