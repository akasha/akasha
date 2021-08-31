package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class OtherPushPermissionDescriptorTestCompile {
  static OtherPushPermissionDescriptor $typeReference$;

  public static OtherPushPermissionDescriptor.Builder create(final String name,
      final boolean safe) {
    return OtherPushPermissionDescriptor.create( name, safe );
  }

  public static boolean safe(final OtherPushPermissionDescriptor $instance) {
    return $instance.safe();
  }

  public static void setSafe(final OtherPushPermissionDescriptor $instance, boolean safe) {
    $instance.setSafe( safe );
  }

  public static OtherPushPermissionDescriptor.Builder safe(
      final OtherPushPermissionDescriptor.Builder $instance, final boolean safe) {
    return $instance.safe( safe );
  }

  public static OtherPushPermissionDescriptor.Builder userVisibleOnly(
      final OtherPushPermissionDescriptor.Builder $instance, final boolean userVisibleOnly) {
    return $instance.userVisibleOnly( userVisibleOnly );
  }

  public static OtherPushPermissionDescriptor.Builder name(
      final OtherPushPermissionDescriptor.Builder $instance, final String name) {
    return $instance.name( name );
  }
}
