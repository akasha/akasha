package com.example;

import com.example.web_assembly.Module;
import elemental2.core.ArrayBuffer;
import elemental2.promise.Promise;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebAssembly"
)
public class WebAssembly {
  WebAssembly() {
  }

  @Nonnull
  public native Promise<Module> compile(@Nonnull ArrayBuffer bytes);
}
