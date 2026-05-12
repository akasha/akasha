package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeInterface"
)
public class SomeInterface {
  public SomeInterface(final @JsNonNull String serviceUuid) {
  }

  public SomeInterface(final int serviceUuid) {
  }

  public static native void myStaticMethodWithUnionArg(@JsNonNull String serviceUuid);

  public static native void myStaticMethodWithUnionArg(int serviceUuid);

  @JsNonNull
  public static native StringOrUnsignedLongUnion myStaticMethodWithUnionReturn();

  @JsNonNull
  public native StringOrUnsignedLongUnion getUuid();
}
