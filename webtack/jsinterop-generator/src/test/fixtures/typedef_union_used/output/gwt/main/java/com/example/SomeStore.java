package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "SomeStore"
)
public class SomeStore {
  protected SomeStore() {
  }

  /**
   * Anonymous Union contains a lower cased element and will be generated.
   */
  @JsProperty(
      name = "transactionMode"
  )
  @Nonnull
  public native LongOrTxModeUnion transactionMode();
}
