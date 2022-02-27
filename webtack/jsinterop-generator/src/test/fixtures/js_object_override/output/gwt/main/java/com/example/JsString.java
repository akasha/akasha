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
    name = "String"
)
public class JsString {
  protected JsString() {
  }

  @JsMethod(
      name = "toString"
  )
  @JsNonNull
  public native String toString_();

  @JsNonNull
  public native String valueOf();
}
