package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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
  @JsNonNull
  public static Object staticObjectValue;

  @JsNonNull
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

  @JsNonNull
  public static native Object staticMethod();

  @JsNonNull
  public static native Object staticMethod2();

  @HasNoSideEffects
  @JsNullable
  public native Element item3(int index);
}
