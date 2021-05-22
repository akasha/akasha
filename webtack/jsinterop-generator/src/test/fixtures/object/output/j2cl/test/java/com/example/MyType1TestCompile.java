package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyType1TestCompile {
  static MyType1 $typeReference$;

  public static JsObject objectValue(final MyType1 type) {
    return type.objectValue;
  }

  public static void objectValue(final MyType1 type, final JsObject value) {
    type.objectValue = value;
  }

  public static JsObject readonlyObjectValue(final MyType1 type) {
    return type.readonlyObjectValue();
  }

  public static JsObject staticObjectValue() {
    return MyType1.staticObjectValue;
  }

  public static void staticObjectValue(final JsObject value) {
    MyType1.staticObjectValue = value;
  }

  public static JsObject staticReadonlyObjectValue() {
    return MyType1.staticReadonlyObjectValue();
  }

  public static JsObject staticOjectMethod(final JsObject v1, final JsObject v2) {
    return MyType1.staticOjectMethod( v1, v2 );
  }

  public static JsObject staticOjectMethod(final JsObject v1) {
    return MyType1.staticOjectMethod( v1 );
  }

  public static JsObject objectMethod(final MyType1 $instance, final JsObject v1,
      final JsObject v2) {
    return $instance.objectMethod( v1, v2 );
  }

  public static JsObject objectMethod(final MyType1 $instance, final JsObject v1) {
    return $instance.objectMethod( v1 );
  }
}
