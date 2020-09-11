package com.example;

import com.biz.MyActiveMode;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WebAssembly"
)
public final class WebAssembly {
  private WebAssembly() {
  }

  public native boolean validate(
      @MagicConstant(valuesFromClass = TxMode.class) @Nonnull String txMode,
      @MagicConstant(valuesFromClass = MyActiveMode.class) @Nonnull String mode);
}
