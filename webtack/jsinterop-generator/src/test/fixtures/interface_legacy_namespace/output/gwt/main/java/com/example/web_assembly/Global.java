package com.example.web_assembly;

import com.example.GlobalDescriptor;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
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

  public Global(final @JsNonNull GlobalDescriptor descriptor,
      @DoNotAutobox final @JsNullable Object v) {
  }

  public Global(final @JsNonNull GlobalDescriptor descriptor) {
  }

  @JsNullable
  public native Any valueOf();
}
