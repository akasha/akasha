package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeServiceContainer"
)
public class SomeServiceContainer {
  public SomeServiceContainer(final @JsNonNull BluetoothServiceUUID service) {
  }

  public SomeServiceContainer(final @JsNonNull String service) {
  }

  public SomeServiceContainer(final int service) {
  }

  public SomeServiceContainer() {
  }

  public static native void myStaticMethodWithUnionArg(@JsNonNull BluetoothDescriptorUUID name);

  public static native void myStaticMethodWithUnionArg(@JsNonNull String name);

  public static native void myStaticMethodWithUnionArg(int name);

  public static native void myStaticMethodWithUnionArg();

  @JsNullable
  public static native BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
}
