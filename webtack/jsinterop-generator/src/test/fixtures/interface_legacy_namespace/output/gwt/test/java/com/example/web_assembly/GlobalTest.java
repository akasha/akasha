package com.example.web_assembly;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class GlobalTest {
  public static Any value(final Global type) {
    return type.value;
  }

  public static void value(final Global type, final Any value) {
    type.value = value;
  }

  public static Any valueOf(final Global $instance) {
    return $instance.valueOf();
  }
}
