package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyString"
)
public class MyString {
  protected MyString() {
  }

  @Nonnull
  public native String valueOf();

  @JsMethod(
      name = "toString"
  )
  @Nonnull
  public native String toString_();
}
