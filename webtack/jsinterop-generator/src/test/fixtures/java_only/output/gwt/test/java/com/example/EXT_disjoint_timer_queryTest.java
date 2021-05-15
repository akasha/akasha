package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class EXT_disjoint_timer_queryTest {
  public static Any valueA(final EXT_disjoint_timer_query type) {
    return type.valueA();
  }

  public static Any valueB(final EXT_disjoint_timer_query type) {
    return type.valueB();
  }

  public static void beginQueryEXT(final EXT_disjoint_timer_query $instance, final int target) {
    $instance.beginQueryEXT( target );
  }

  public static void endQueryEXT(final EXT_disjoint_timer_query $instance, final int target) {
    $instance.endQueryEXT( target );
  }
}
