package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "txStorage"
)
public class TxStorage {
  TxStorage() {
  }

  @JsProperty(
      name = "length"
  )
  public native int length();
}
