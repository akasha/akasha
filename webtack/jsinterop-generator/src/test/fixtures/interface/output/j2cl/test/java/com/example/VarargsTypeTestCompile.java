package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class VarargsTypeTestCompile {
  static VarargsType $typeReference$;

  public static void myOperation1(final JsArray<String> tokens) {
    VarargsType.myOperation1( tokens );
  }

  public static void myOperation1(final String[] tokens) {
    VarargsType.myOperation1( tokens );
  }

  public static void myOperation2(final VarargsType $instance, final JsArray<String> tokens) {
    $instance.myOperation2( tokens );
  }

  public static void myOperation2(final VarargsType $instance, final String[] tokens) {
    $instance.myOperation2( tokens );
  }
}
