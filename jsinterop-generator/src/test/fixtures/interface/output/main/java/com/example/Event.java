package com.example;

import elemental2.core.JsArray;
import elemental2.promise.Promise;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

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

  @Nullable
  public Any mutableAny;

  public boolean returnValue;

  public Event(@Nonnull final String type, @Nonnull final EventInit eventInitDict) {
  }

  public Event(@Nonnull final String type) {
  }

  @JsProperty(
      name = "bubbles"
  )
  public native boolean bubbles();

  @JsProperty(
      name = "cancelable"
  )
  public native boolean cancelable();

  @JsProperty(
      name = "composed"
  )
  public native boolean composed();

  @JsProperty(
      name = "currentTarget"
  )
  @Nullable
  public native EventTarget currentTarget();

  @JsProperty(
      name = "defaultPrevented"
  )
  public native boolean defaultPrevented();

  @JsProperty(
      name = "eventPhase"
  )
  public native int eventPhase();

  @JsProperty(
      name = "isTrusted"
  )
  public native boolean isTrusted();

  @JsProperty(
      name = "readonlyAny"
  )
  @Nullable
  public native Any readonlyAny();

  @JsProperty(
      name = "srcElement"
  )
  @Nullable
  public native EventTarget srcElement();

  @JsProperty(
      name = "target"
  )
  @Nullable
  public native EventTarget target();

  @JsProperty(
      name = "type"
  )
  @Nonnull
  public native String type();

  @Nonnull
  public native Promise<Any> anyInReturnedPromise();

  public native void anyParameter(@DoNotAutobox @Nullable Object value);

  @Nullable
  public native Any anyReturning();

  @Nonnull
  public native JsArray<EventTarget> composedPath();

  public native void initEvent(@Nonnull String type, boolean bubbles, boolean cancelable);

  public native void initEvent(@Nonnull String type, boolean bubbles);

  public native void initEvent(@Nonnull String type);

  public native void preventDefault();

  public native void stopImmediatePropagation();

  public native void stopPropagation();
}
