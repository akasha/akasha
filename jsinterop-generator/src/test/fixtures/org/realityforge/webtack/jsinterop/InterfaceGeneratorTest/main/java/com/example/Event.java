package com.example;

import elemental2.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Event"
)
public class Event {
  @JsOverlay
  public static final int AT_TARGET = 2;

  @JsOverlay
  public static final int BUBBLING_PHASE = 3;

  @JsOverlay
  public static final int CAPTURING_PHASE = 1;

  @JsOverlay
  public static final int NONE = 0;

  public boolean cancelBubble;

  public boolean returnValue;

  public Event(@Nonnull final String type, @Nonnull final EventInit eventInitDict) {
  }

  public Event(@Nonnull final String type) {
  }

  public native boolean bubbles();

  public native boolean cancelable();

  public native boolean composed();

  @Nullable
  public native EventTarget currentTarget();

  public native boolean defaultPrevented();

  public native int eventPhase();

  public native boolean isTrusted();

  @Nullable
  public native EventTarget srcElement();

  @Nullable
  public native EventTarget target();

  @Nonnull
  public native String type();

  @Nonnull
  public native JsArray<EventTarget> composedPath();

  public native void initEvent(@Nonnull String type, boolean bubbles, boolean cancelable);

  public native void initEvent(@Nonnull String type, boolean bubbles);

  public native void initEvent(@Nonnull String type);

  public native void preventDefault();

  public native void stopImmediatePropagation();

  public native void stopPropagation();
}
