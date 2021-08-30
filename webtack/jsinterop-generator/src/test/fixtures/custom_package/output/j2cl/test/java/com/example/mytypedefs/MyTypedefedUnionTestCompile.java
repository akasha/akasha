package com.example.mytypedefs;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyTypedefedUnionTestCompile {
  public static MyTypedefedUnion of(final String value) {
    return MyTypedefedUnion.of( value );
  }

  public static MyTypedefedUnion of(final double value) {
    return MyTypedefedUnion.of( value );
  }

  public static boolean isDouble(final MyTypedefedUnion $instance) {
    return $instance.isDouble();
  }

  public static double asDouble(final MyTypedefedUnion $instance) {
    return $instance.asDouble();
  }

  public static boolean isString(final MyTypedefedUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final MyTypedefedUnion $instance) {
    return $instance.asString();
  }
}
