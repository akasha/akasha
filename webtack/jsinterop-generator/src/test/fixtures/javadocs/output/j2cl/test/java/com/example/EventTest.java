package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventTest {
  static Event $typeReference$;

  public static boolean bubbles(final Event type) {
    return type.bubbles();
  }

  public static boolean cancelBubble(final Event type) {
    return type.cancelBubble;
  }

  public static void cancelBubble(final Event type, final boolean value) {
    type.cancelBubble = value;
  }

  public static Event filterGlobalEvent(final String type) {
    return Event.filterGlobalEvent( type );
  }

  public static JsArray<EventTarget> composedPath(final Event $instance) {
    return $instance.composedPath();
  }
}
