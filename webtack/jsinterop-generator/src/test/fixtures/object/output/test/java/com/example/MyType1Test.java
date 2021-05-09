package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyType1Test {
  public static Object objectValue(final MyType1 type) {
    return type.objectValue;
  }

  public static void objectValue(final MyType1 type, final Object value) {
    type.objectValue = value;
  }

  public static Object readonlyObjectValue(final MyType1 type) {
    return type.readonlyObjectValue();
  }

  public static Object staticObjectValue() {
    return MyType1.staticObjectValue;
  }

  public static void staticObjectValue(final Object value) {
    MyType1.staticObjectValue = value;
  }

  public static Object staticReadonlyObjectValue() {
    return MyType1.staticReadonlyObjectValue();
  }

  public static Object staticOjectMethod(final Object v1, final Object v2) {
    return MyType1.staticOjectMethod( v1, v2 );
  }

  public static Object staticOjectMethod(final Object v1) {
    return MyType1.staticOjectMethod( v1 );
  }

  public static Object objectMethod(final MyType1 $instance, final Object v1, final Object v2) {
    return $instance.objectMethod( v1, v2 );
  }

  public static Object objectMethod(final MyType1 $instance, final Object v1) {
    return $instance.objectMethod( v1 );
  }
}
