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
  public static JsObject staticObjectValue;

  @Nonnull
  public JsObject objectValue;

  protected MyType1() {
  }

  @JsProperty(
      name = "readonlyObjectValue"
  )
  @Nonnull
  public native JsObject readonlyObjectValue();

  @JsProperty(
      name = "staticReadonlyObjectValue"
  )
  @Nonnull
  public static native JsObject staticReadonlyObjectValue();

  @Nonnull
  public static native JsObject staticOjectMethod(@Nonnull JsObject v1, @Nonnull JsObject v2);

  @Nonnull
  public static native JsObject staticOjectMethod(@Nonnull JsObject v1);

  @Nonnull
  public native JsObject objectMethod(@Nonnull JsObject v1, @Nonnull JsObject v2);

  @Nonnull
  public native JsObject objectMethod(@Nonnull JsObject v1);
}
