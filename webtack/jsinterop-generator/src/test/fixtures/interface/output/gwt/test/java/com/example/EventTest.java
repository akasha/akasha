package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class EventTest {
  public static boolean bubbles(final Event type) {
    return type.bubbles();
  }

  public static boolean cancelBubble(final Event type) {
    return type.cancelBubble;
  }

  public static void cancelBubble(final Event type, final boolean value) {
    type.cancelBubble = value;
  }

  public static boolean cancelable(final Event type) {
    return type.cancelable();
  }

  public static boolean composed(final Event type) {
    return type.composed();
  }

  public static EventTarget currentTarget(final Event type) {
    return type.currentTarget();
  }

  public static boolean defaultPrevented(final Event type) {
    return type.defaultPrevented();
  }

  public static int eventPhase(final Event type) {
    return type.eventPhase();
  }

  public static boolean isTrusted(final Event type) {
    return type.isTrusted();
  }

  public static Any mutableAny(final Event type) {
    return type.mutableAny;
  }

  public static void mutableAny(final Event type, final Any value) {
    type.mutableAny = value;
  }

  public static Any readonlyAny(final Event type) {
    return type.readonlyAny();
  }

  public static boolean returnValue(final Event type) {
    return type.returnValue;
  }

  public static void returnValue(final Event type, final boolean value) {
    type.returnValue = value;
  }

  public static EventTarget srcElement(final Event type) {
    return type.srcElement();
  }

  public static EventTarget target(final Event type) {
    return type.target();
  }

  public static String type(final Event type) {
    return type.type();
  }

  public static JsPromise<Any> anyInReturnedPromise(final Event $instance) {
    return $instance.anyInReturnedPromise();
  }

  public static void anyParameter(final Event $instance, @DoNotAutobox final Object value) {
    $instance.anyParameter( value );
  }

  public static Any anyReturning(final Event $instance) {
    return $instance.anyReturning();
  }

  public static JsArray<EventTarget> composedPath(final Event $instance) {
    return $instance.composedPath();
  }

  public static void initEvent(final Event $instance, final String type, final boolean bubbles,
      final boolean cancelable) {
    $instance.initEvent( type, bubbles, cancelable );
  }

  public static void initEvent(final Event $instance, final String type, final boolean bubbles) {
    $instance.initEvent( type, bubbles );
  }

  public static void initEvent(final Event $instance, final String type) {
    $instance.initEvent( type );
  }

  public static void preventDefault(final Event $instance) {
    $instance.preventDefault();
  }

  public static void stopImmediatePropagation(final Event $instance) {
    $instance.stopImmediatePropagation();
  }

  public static void stopPropagation(final Event $instance) {
    $instance.stopPropagation();
  }
}
