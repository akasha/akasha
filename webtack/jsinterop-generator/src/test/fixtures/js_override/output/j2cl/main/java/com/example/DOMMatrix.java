package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "DOMMatrix"
)
public class DOMMatrix extends DOMMatrixReadOnly {
  protected DOMMatrix() {
  }

  @JsNonNull
  public static native DOMMatrix fromMatrix(@Nonnull Object other);

  @JsNonNull
  public static native DOMMatrix fromMatrix();
}
