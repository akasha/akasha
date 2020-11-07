package com.example;

import com.biz.MyActiveMode;
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
public final class WebAssemblyNamespace {
  private WebAssemblyNamespace() {
  }

  public native boolean validate(@TxMode @Nonnull String txMode,
      @MyActiveMode @Nonnull String mode);
}
