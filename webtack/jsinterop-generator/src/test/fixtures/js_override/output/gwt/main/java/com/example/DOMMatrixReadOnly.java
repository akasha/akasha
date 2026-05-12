package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMMatrixReadOnly"
)
public class DOMMatrixReadOnly {
  protected DOMMatrixReadOnly() {
  }

  @JsNonNull
  public static native DOMMatrixReadOnly fromMatrix(@JsNonNull Object other);

  @JsNonNull
  public static native DOMMatrixReadOnly fromMatrix();
}
