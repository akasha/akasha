package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class UnionObjectOrStringTestCompile {
  static UnionObjectOrString $typeReference$;

  public static UnionObjectOrString of(final JsObject value) {
    return UnionObjectOrString.of( value );
  }

  public static UnionObjectOrString of(final String value) {
    return UnionObjectOrString.of( value );
  }

  public static boolean isObject(final UnionObjectOrString $instance) {
    return $instance.isObject();
  }

  public static JsObject asObject(final UnionObjectOrString $instance) {
    return $instance.asObject();
  }

  public static boolean isString(final UnionObjectOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final UnionObjectOrString $instance) {
    return $instance.asString();
  }
}
