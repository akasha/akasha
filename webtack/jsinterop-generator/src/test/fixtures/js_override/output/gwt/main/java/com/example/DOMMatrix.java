package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

  @Nonnull
  public static native DOMMatrix fromMatrix(@Nonnull Object other);

  @Nonnull
  public static native DOMMatrix fromMatrix();
}
