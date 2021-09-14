package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class EventOrStringUnionTestCompile {
  static EventOrStringUnion $typeReference$;

  public static EventOrStringUnion of(final Event value) {
    return EventOrStringUnion.of( value );
  }

  public static EventOrStringUnion of(final String value) {
    return EventOrStringUnion.of( value );
  }

  public static boolean isEvent(final EventOrStringUnion $instance) {
    return $instance.isEvent();
  }

  public static Event asEvent(final EventOrStringUnion $instance) {
    return $instance.asEvent();
  }

  public static boolean isString(final EventOrStringUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final EventOrStringUnion $instance) {
    return $instance.asString();
  }
}
