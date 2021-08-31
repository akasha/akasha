package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class PostMessageOptionsTestCompile {
  static PostMessageOptions $typeReference$;

  public static PostMessageOptions.Builder create() {
    return PostMessageOptions.create();
  }

  public static JsArray<Object> transfer(final PostMessageOptions $instance) {
    return $instance.transfer();
  }

  public static void setTransfer(final PostMessageOptions $instance, JsArray<Object> transfer) {
    $instance.setTransfer( transfer );
  }

  public static void setTransfer(final PostMessageOptions $instance, final Object[] transfer) {
    $instance.setTransfer( transfer );
  }

  public static PostMessageOptions.Builder transfer(final PostMessageOptions.Builder $instance,
      final JsArray<Object> transfer) {
    return $instance.transfer( transfer );
  }

  public static PostMessageOptions.Builder transfer(final PostMessageOptions.Builder $instance,
      final Object[] transfer) {
    return $instance.transfer( transfer );
  }
}
