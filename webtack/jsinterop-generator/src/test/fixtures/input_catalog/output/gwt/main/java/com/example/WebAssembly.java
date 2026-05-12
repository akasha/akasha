package com.example;

import com.biz.MyActiveMode;
import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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

  public static native boolean validate(@TxMode @Nonnull String txMode,
      @MyActiveMode @Nonnull String mode);
}
