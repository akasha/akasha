package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class PushPermissionDescriptorTestCompile {
  static PushPermissionDescriptor $typeReference$;

  public static PushPermissionDescriptor.Builder name(final String name) {
    return PushPermissionDescriptor.name( name );
  }

  public static boolean userVisibleOnly(final PushPermissionDescriptor $instance) {
    return $instance.userVisibleOnly();
  }

  public static void setUserVisibleOnly(final PushPermissionDescriptor $instance,
      boolean userVisibleOnly) {
    $instance.setUserVisibleOnly( userVisibleOnly );
  }

  public static PushPermissionDescriptor.Builder userVisibleOnly(
      final PushPermissionDescriptor.Builder $instance, final boolean userVisibleOnly) {
    return $instance.userVisibleOnly( userVisibleOnly );
  }
}
