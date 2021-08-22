package com.example.web_assembly;

import com.example.GlobalDescriptor;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebAssembly.Global"
)
public class Global {
  @JsNullable
  public Any value;

  public Global(@Nonnull final GlobalDescriptor descriptor,
      @DoNotAutobox @Nullable final Object v) {
  }

  public Global(@Nonnull final GlobalDescriptor descriptor) {
  }

  @JsNullable
  public native Any valueOf();
}
