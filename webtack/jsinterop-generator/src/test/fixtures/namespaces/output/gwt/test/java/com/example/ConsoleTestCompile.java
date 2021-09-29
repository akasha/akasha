package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ConsoleTestCompile {
  public static void assert_(final boolean condition, @DoNotAutobox final Object[] data) {
    Console.assert_( condition, data );
  }

  public static void assert_(final boolean condition) {
    Console.assert_( condition );
  }

  public static void clear() {
    Console.clear();
  }

  public static void table(@DoNotAutobox final Object tabularData,
      final JsArray<String> properties) {
    Console.table( tabularData, properties );
  }

  public static void table(@DoNotAutobox final Object tabularData, final String[] properties) {
    Console.table( tabularData, properties );
  }

  public static void table(@DoNotAutobox final Object tabularData) {
    Console.table( tabularData );
  }

  public static void table() {
    Console.table();
  }

  public static void warn(@DoNotAutobox final Object[] data) {
    Console.warn( data );
  }
}
