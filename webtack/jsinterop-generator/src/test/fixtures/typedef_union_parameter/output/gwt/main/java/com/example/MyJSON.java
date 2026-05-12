package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyJSON"
)
public class MyJSON {
  protected MyJSON() {
  }

  @JsNonNull
  public native String stringify(@DoNotAutobox @JsNullable Object value,
      @JsNullable StringifySpaceUnionType space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @JsNullable Object value, @JsNonNull String space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @JsNullable Object value, int space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @JsNullable Object value);
}
