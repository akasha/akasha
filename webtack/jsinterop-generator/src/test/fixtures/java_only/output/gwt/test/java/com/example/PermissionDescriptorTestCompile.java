package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class PermissionDescriptorTestCompile {
  static PermissionDescriptor $typeReference$;

  public static PermissionDescriptor.Builder create(final String name1, final String name2) {
    return PermissionDescriptor.create( name1, name2 );
  }

  public static String name1(final PermissionDescriptor $instance) {
    return $instance.name1();
  }

  public static void setName1(final PermissionDescriptor $instance, String name1) {
    $instance.setName1( name1 );
  }

  public static String name2(final PermissionDescriptor $instance) {
    return $instance.name2();
  }

  public static void setName2(final PermissionDescriptor $instance, String name2) {
    $instance.setName2( name2 );
  }

  public static boolean userVisibleOnly1(final PermissionDescriptor $instance) {
    return $instance.userVisibleOnly1();
  }

  public static void setUserVisibleOnly1(final PermissionDescriptor $instance,
      boolean userVisibleOnly1) {
    $instance.setUserVisibleOnly1( userVisibleOnly1 );
  }

  public static boolean userVisibleOnly2(final PermissionDescriptor $instance) {
    return $instance.userVisibleOnly2();
  }

  public static void setUserVisibleOnly2(final PermissionDescriptor $instance,
      boolean userVisibleOnly2) {
    $instance.setUserVisibleOnly2( userVisibleOnly2 );
  }

  public static PermissionDescriptor.Builder name1(final PermissionDescriptor.Builder $instance,
      final String name1) {
    return $instance.name1( name1 );
  }

  public static PermissionDescriptor.Builder name2(final PermissionDescriptor.Builder $instance,
      final String name2) {
    return $instance.name2( name2 );
  }

  public static PermissionDescriptor.Builder userVisibleOnly1(
      final PermissionDescriptor.Builder $instance, final boolean userVisibleOnly1) {
    return $instance.userVisibleOnly1( userVisibleOnly1 );
  }

  public static PermissionDescriptor.Builder userVisibleOnly2(
      final PermissionDescriptor.Builder $instance, final boolean userVisibleOnly2) {
    return $instance.userVisibleOnly2( userVisibleOnly2 );
  }
}
