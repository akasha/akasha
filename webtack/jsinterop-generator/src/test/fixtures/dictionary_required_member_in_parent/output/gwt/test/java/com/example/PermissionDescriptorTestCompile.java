package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class PermissionDescriptorTestCompile {
  static PermissionDescriptor $typeReference$;

  public static PermissionDescriptor.Builder name(final String name) {
    return PermissionDescriptor.name( name );
  }

  public static String name(final PermissionDescriptor $instance) {
    return $instance.name();
  }

  public static void setName(final PermissionDescriptor $instance, String name) {
    $instance.setName( name );
  }

  public static PermissionDescriptor.Builder name(final PermissionDescriptor.Builder $instance,
      final String name) {
    return $instance.name( name );
  }
}
