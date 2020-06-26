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

  public final boolean bubbles;

  public final boolean cancelable;

  public final boolean composed;

  @Nullable
  public final EventTarget currentTarget;

  public final boolean defaultPrevented;

  public final int eventPhase;

  public final boolean isTrusted;

  @Nullable
  public final EventTarget srcElement;

  @Nullable
  public final EventTarget target;

  @Nonnull
  public final String type;

  public boolean cancelBubble;

  public boolean returnValue;

  public Event(@Nonnull final String type, @Nonnull final EventInit eventInitDict) {
    // Initialize read-only attributes. This is done to satisfy the JVM and will be ignored when transpiled to javascript.
    this.bubbles = false;
    this.cancelable = false;
    this.composed = false;
    this.currentTarget = null;
    this.defaultPrevented = false;
    this.eventPhase = 0;
    this.isTrusted = false;
    this.srcElement = null;
    this.target = null;
    this.type = null;
  }

  public Event(@Nonnull final String type) {
    // Initialize read-only attributes. This is done to satisfy the JVM and will be ignored when transpiled to javascript.
    this.bubbles = false;
    this.cancelable = false;
    this.composed = false;
    this.currentTarget = null;
    this.defaultPrevented = false;
    this.eventPhase = 0;
    this.isTrusted = false;
    this.srcElement = null;
    this.target = null;
    this.type = null;
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
