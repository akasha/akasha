package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyType1"
)
public class MyType1 {
  @Nonnull
  public static Object staticObjectValue;

  @Nonnull
  public Object objectValue;

  protected MyType1() {
  }

  @JsProperty(
      name = "readonlyObjectValue"
  )
  @Nonnull
  public native Object readonlyObjectValue();

  @JsProperty(
      name = "staticReadonlyObjectValue"
  )
  @Nonnull
  public static native Object staticReadonlyObjectValue();

  @Nonnull
  public static native Object staticOjectMethod(@Nonnull Object v1, @Nonnull Object v2);

  @Nonnull
  public static native Object staticOjectMethod(@Nonnull Object v1);

  @Nonnull
  public native Object objectMethod(@Nonnull Object v1, @Nonnull Object v2);

  @Nonnull
  public native Object objectMethod(@Nonnull Object v1);
}
