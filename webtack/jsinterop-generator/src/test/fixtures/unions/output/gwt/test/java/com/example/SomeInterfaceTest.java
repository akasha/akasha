package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class SomeInterfaceTest {
  static SomeInterface $typeReference$;

  public static void myStaticMethodWithUnionArg(final String serviceUuid) {
    SomeInterface.myStaticMethodWithUnionArg( serviceUuid );
  }

  public static void myStaticMethodWithUnionArg(final int serviceUuid) {
    SomeInterface.myStaticMethodWithUnionArg( serviceUuid );
  }

  public static StringOrUnsignedLongUnion myStaticMethodWithUnionReturn() {
    return SomeInterface.myStaticMethodWithUnionReturn();
  }

  public static StringOrUnsignedLongUnion getUuid(final SomeInterface $instance) {
    return $instance.getUuid();
  }
}
