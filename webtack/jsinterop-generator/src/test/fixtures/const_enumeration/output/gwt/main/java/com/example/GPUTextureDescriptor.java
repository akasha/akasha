package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  static Builder create(@GPUTextureUsageFlags final int usage) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).usage( usage );
  }

  @JsProperty(
      name = "usage"
  )
  @GPUTextureUsageFlags
  @Nonnull
  int usage();

  @JsProperty
  void setUsage(@GPUTextureUsageFlags @Nonnull int usage);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
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