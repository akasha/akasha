package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "JSON"
)
public class JSON {
  protected JSON() {
  }

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value,
      @Nullable StringifySpaceUnionType space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value, @Nonnull String space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value, int space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value);
}
