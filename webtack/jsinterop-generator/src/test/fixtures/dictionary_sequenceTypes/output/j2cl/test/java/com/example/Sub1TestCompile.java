package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class Sub1TestCompile {
  static Sub1 $typeReference$;

  public static Sub1.Builder of() {
    return Sub1.of();
  }

  public static JsArray<Base> others(final Sub1 $instance) {
    return $instance.others();
  }

  public static void setOthers(final Sub1 $instance, JsArray<Base> others) {
    $instance.setOthers( others );
  }

  public static void setOthers(final Sub1 $instance, final Base[] others) {
    $instance.setOthers( others );
  }

  public static Sub1.Builder others(final Sub1.Builder $instance, final JsArray<Base> others) {
    return $instance.others( others );
  }

  public static Sub1.Builder others(final Sub1.Builder $instance, final Base[] others) {
    return $instance.others( others );
  }
}
