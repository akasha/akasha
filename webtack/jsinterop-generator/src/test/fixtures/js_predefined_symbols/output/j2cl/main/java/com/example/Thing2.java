package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Thing2"
)
public class Thing2 {
  @Nonnull
  public static Object staticObjectValue;

  @Nonnull
  public static Object staticObjectValue2;

  protected Thing2() {
  }

  @JsProperty(
      name = "length3"
  )
  public native int length3();

  @JsProperty(
      name = "staticReadonlyObjectValue"
  )
  @Nonnull
  public static native Object staticReadonlyObjectValue();

  @JsProperty(
      name = "staticReadonlyObjectValue2"
  )
  @Nonnull
  public static native Object staticReadonlyObjectValue2();

  @Nonnull
  public static native Object staticMethod();

  @Nonnull
  public static native Object staticMethod2();

  @HasNoSideEffects
  @Nullable
  public native Element item3(int index);
}
