package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class EventOrStringUnionTestCompile {
  public static EventOrStringUnion of(final EventOrStringUnion $instance,
      @Nonnull final Event value) {
    return EventOrStringUnion.of( value );
  }

  public static EventOrStringUnion of(final EventOrStringUnion $instance,
      @Nonnull final String value) {
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
