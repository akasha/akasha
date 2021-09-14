package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class GlobalTestCompile {
  public static String escape(final String str) {
    return Global.escape( str );
  }

  public static boolean isFinite(final double num) {
    return Global.isFinite( num );
  }

  public static boolean isNaN(final double value) {
    return Global.isNaN( value );
  }

  public static int parseInt(final String string, final int radix) {
    return Global.parseInt( string, radix );
  }

  public static String unescape(final String str) {
    return Global.unescape( str );
  }
}
