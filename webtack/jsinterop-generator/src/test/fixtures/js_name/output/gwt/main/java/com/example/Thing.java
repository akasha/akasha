package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNullable;
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

  @JsMethod(
      name = "leItem"
  )
  @HasNoSideEffects
  @JsNullable
  public native Element item(int index);
}
