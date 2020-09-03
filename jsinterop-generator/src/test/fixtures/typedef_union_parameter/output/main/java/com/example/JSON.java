package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "JSON"
)
public class JSON {
  JSON() {
  }

  @Nonnull
  public native String stringify(@Nullable Any value, @Nullable StringifySpaceUnionType space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value,
      @Nullable StringifySpaceUnionType space);

  @Nonnull
  public native String stringify(@Nullable Any value, @Nonnull String space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value, @Nonnull String space);

  @Nonnull
  public native String stringify(@Nullable Any value, int space);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value, int space);

  @Nonnull
  public native String stringify(@Nullable Any value);

  @Nonnull
  public native String stringify(@DoNotAutobox @Nullable Object value);
}
