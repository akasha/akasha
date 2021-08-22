package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyDate"
)
public class MyDate {
  protected MyDate() {
  }

  public native double valueOf();

  @JsMethod(
      name = "toString"
  )
  @JsNonNull
  public native String toString_();
}
