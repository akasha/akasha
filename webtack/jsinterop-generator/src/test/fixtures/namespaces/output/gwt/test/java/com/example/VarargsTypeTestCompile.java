package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class VarargsTypeTestCompile {
  public static void myOperation1(final JsArray<String> tokens) {
    VarargsType.myOperation1( tokens );
  }

  public static void myOperation1(final String[] tokens) {
    VarargsType.myOperation1( tokens );
  }

  public static void myOperation2(final JsArray<String> tokens1, final JsArray<String> tokens2) {
    VarargsType.myOperation2( tokens1, tokens2 );
  }

  public static void myOperation2(final String[] tokens1, final String[] tokens2) {
    VarargsType.myOperation2( tokens1, tokens2 );
  }
}
