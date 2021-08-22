package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
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
  public native String stringify(@DoNotAutobox @Nullable Object value,
      @Nullable StringifySpaceUnionType space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @Nullable Object value, @Nonnull String space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @Nullable Object value, int space);

  @JsNonNull
  public native String stringify(@DoNotAutobox @Nullable Object value);
}
