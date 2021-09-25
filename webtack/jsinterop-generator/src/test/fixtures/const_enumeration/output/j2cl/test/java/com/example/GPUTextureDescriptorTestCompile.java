package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class GPUTextureDescriptorTestCompile {
  static GPUTextureDescriptor $typeReference$;

  public static GPUTextureDescriptor.Builder usage(final int usage) {
    return GPUTextureDescriptor.usage( usage );
  }

  public static int usage(final GPUTextureDescriptor $instance) {
    return $instance.usage();
  }

  public static void setUsage(final GPUTextureDescriptor $instance, int usage) {
    $instance.setUsage( usage );
  }

  public static GPUTextureDescriptor.Builder usage(final GPUTextureDescriptor.Builder $instance,
      final int usage) {
    return $instance.usage( usage );
  }
}
