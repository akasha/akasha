package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class PermissionStateOrLongTestCompile {
  public static PermissionStateOrLong of(final PermissionStateOrLong $instance,
      @PermissionState final String value) {
    return PermissionStateOrLong.of( value );
  }

  public static PermissionStateOrLong of(final PermissionStateOrLong $instance, final int value) {
    return PermissionStateOrLong.of( value );
  }

  public static boolean isInt(final PermissionStateOrLong $instance) {
    return $instance.isInt();
  }

  public static int asInt(final PermissionStateOrLong $instance) {
    return $instance.asInt();
  }

  public static boolean isPermissionState(final PermissionStateOrLong $instance) {
    return $instance.isPermissionState();
  }

  public static String asPermissionState(final PermissionStateOrLong $instance) {
    return $instance.asPermissionState();
  }
}
