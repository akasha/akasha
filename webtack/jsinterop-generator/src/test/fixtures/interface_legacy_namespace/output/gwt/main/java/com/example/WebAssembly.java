package com.example;

import com.example.web_assembly.Module;
import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(
    isNative = true,
    name = "WebAssembly",
    namespace = JsPackage.GLOBAL
)
@Generated("org.realityforge.webtack")
public final class WebAssembly {
  private WebAssembly() {
  }

  @JsNonNull
  public static native JsPromise<Module> compile(@Nonnull ArrayBuffer bytes);
}
