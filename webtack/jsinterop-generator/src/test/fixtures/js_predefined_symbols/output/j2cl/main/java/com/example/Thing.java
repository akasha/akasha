package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Thing"
)
public class Thing {
  protected Thing() {
  }

  @JsProperty(
      name = "zeSize"
  )
  public native int length();

  @JsProperty(
      name = "length2"
  )
  public native int length2();

  @JsProperty(
      name = "length3"
  )
  public native int length3();

  @JsMethod(
      name = "leItem"
  )
  @HasNoSideEffects
  @Nullable
  public native Element item(int index);

  @HasNoSideEffects
  @Nullable
  public native Element item2(int index);

  @HasNoSideEffects
  @Nullable
  public native Element item3(int index);
}
