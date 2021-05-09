package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ConsoleTest {
  public static void assert_(final boolean condition, @DoNotAutobox final Object[] data) {
    Console.assert_( condition, data );
  }

  public static void assert_(final boolean condition) {
    Console.assert_( condition );
  }

  public static void clear() {
    Console.clear();
  }

  public static void warn(@DoNotAutobox final Object[] data) {
    Console.warn( data );
  }
}
