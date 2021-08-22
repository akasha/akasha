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
    name = "MyBoolean"
)
public class MyBoolean {
  protected MyBoolean() {
  }

  public native boolean valueOf();

  @JsMethod(
      name = "toString"
  )
  @JsNonNull
  public native String toString_();
}
