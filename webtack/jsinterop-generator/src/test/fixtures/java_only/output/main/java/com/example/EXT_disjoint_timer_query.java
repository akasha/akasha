package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "EXT_disjoint_timer_query"
)
public class EXT_disjoint_timer_query {
  @JsOverlay
  public static final String NAME = "EXT_disjoint_timer_query";

  @JsOverlay
  public static final int QUERY_COUNTER_BITS_EXT = 0x8864;

  @JsOverlay
  public static final int QUERY_RESULT_AVAILABLE_EXT = 0x8867;

  protected EXT_disjoint_timer_query() {
  }

  @JsProperty(
      name = "valueA"
  )
  @Nullable
  public native Any valueA();

  @JsProperty(
      name = "valueB"
  )
  @Nullable
  public native Any valueB();

  public native void beginQueryEXT(int target);

  public native void endQueryEXT(int target);
}
