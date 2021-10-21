package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface GPUTextureDescriptor {
  @JsOverlay
  @Nonnull
  static GPUTextureDescriptor usage(@GPUTextureUsageFlags final int usage) {
    final GPUTextureDescriptor $gpuTextureDescriptor = Js.<GPUTextureDescriptor>uncheckedCast( JsPropertyMap.of() );
    $gpuTextureDescriptor.setUsage( usage );
    return Js.uncheckedCast( $gpuTextureDescriptor );
  }

  @JsProperty(
      name = "usage"
  )
  @GPUTextureUsageFlags
  @JsNonNull
  int usage();

  @JsProperty
  void setUsage(@GPUTextureUsageFlags @JsNonNull int usage);
}
