package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  public SomeInterface(@Nonnull final String serviceUuid) {
  }

  public SomeInterface(final int serviceUuid) {
  }

  public static native void myStaticMethodWithUnionArg(@Nonnull String serviceUuid);

  public static native void myStaticMethodWithUnionArg(int serviceUuid);

  @JsNonNull
  public static native StringOrUnsignedLongUnion myStaticMethodWithUnionReturn();

  @JsNonNull
  public native StringOrUnsignedLongUnion getUuid();
}
