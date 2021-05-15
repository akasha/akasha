package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyJSONTest {
  public static String stringify(final MyJSON $instance, @DoNotAutobox final Object value,
      final StringifySpaceUnionType space) {
    return $instance.stringify( value, space );
  }

  public static String stringify(final MyJSON $instance, @DoNotAutobox final Object value,
      final String space) {
    return $instance.stringify( value, space );
  }

  public static String stringify(final MyJSON $instance, @DoNotAutobox final Object value,
      final int space) {
    return $instance.stringify( value, space );
  }

  public static String stringify(final MyJSON $instance, @DoNotAutobox final Object value) {
    return $instance.stringify( value );
  }
}
