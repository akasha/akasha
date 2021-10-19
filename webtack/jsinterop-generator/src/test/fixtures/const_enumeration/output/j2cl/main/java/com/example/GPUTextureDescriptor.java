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
    name = "GPUTextureDescriptor"
)
public interface GPUTextureDescriptor {
  @JsOverlay
  @Nonnull
  static Builder usage(@GPUTextureUsageFlags final int usage) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).usage( usage );
  }

  @JsProperty(
      name = "usage"
  )
  @GPUTextureUsageFlags
  @JsNonNull
  int usage();

  @JsProperty
  void setUsage(@GPUTextureUsageFlags @JsNonNull int usage);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "GPUTextureDescriptor"
  )
  interface Builder extends GPUTextureDescriptor {
    @JsOverlay
    @Nonnull
    default Builder usage(@GPUTextureUsageFlags final int usage) {
      setUsage( usage );
      return this;
    }
  }
}
