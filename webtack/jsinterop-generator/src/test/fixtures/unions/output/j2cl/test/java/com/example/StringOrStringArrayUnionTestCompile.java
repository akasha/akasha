package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class StringOrStringArrayUnionTestCompile {
  static StringOrStringArrayUnion $typeReference$;

  public static StringOrStringArrayUnion of(final String value) {
    return StringOrStringArrayUnion.of( value );
  }

  public static StringOrStringArrayUnion of(final JsArray<String> value) {
    return StringOrStringArrayUnion.of( value );
  }

  public static StringOrStringArrayUnion of(final String[] value) {
    return StringOrStringArrayUnion.of( value );
  }

  public static boolean isArray(final StringOrStringArrayUnion $instance) {
    return $instance.isArray();
  }

  public static JsArray<String> asArray(final StringOrStringArrayUnion $instance) {
    return $instance.asArray();
  }

  public static boolean isString(final StringOrStringArrayUnion $instance) {
    return $instance.isString();
  }

  public static String asString(final StringOrStringArrayUnion $instance) {
    return $instance.asString();
  }
}
