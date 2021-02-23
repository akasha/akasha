package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Symbol"
)
public class Symbol {
  protected Symbol() {
  }

  @JsProperty(
      name = "asyncIterator"
  )
  @Nonnull
  public static native Symbol asyncIterator();

  @JsProperty(
      name = "hasInstance"
  )
  @Nonnull
  public static native Symbol hasInstance();

  @JsProperty(
      name = "isConcatSpreadable"
  )
  @Nonnull
  public static native Symbol _isConcatSpreadable();
}
