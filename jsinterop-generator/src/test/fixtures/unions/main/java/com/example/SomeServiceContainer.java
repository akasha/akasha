package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeServiceContainer"
)
public class SomeServiceContainer {
  public SomeServiceContainer(@Nonnull final BluetoothServiceUUID service) {
  }

  public SomeServiceContainer(@Nonnull final String service) {
  }

  public SomeServiceContainer(final int service) {
  }

  public SomeServiceContainer() {
  }

  public static native void myStaticMethodWithUnionArg(@Nonnull BluetoothDescriptorUUID name);

  public static native void myStaticMethodWithUnionArg(@Nonnull String name);

  public static native void myStaticMethodWithUnionArg(int name);

  public static native void myStaticMethodWithUnionArg();

  @Nullable
  public static native BluetoothDescriptorUUID myStaticMethodWithUnionReturn();
}
