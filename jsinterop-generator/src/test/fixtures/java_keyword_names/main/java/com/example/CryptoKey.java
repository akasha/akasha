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
    name = "CryptoKey"
)
public class CryptoKey {
  @JsProperty(
      name = "default"
  )
  public boolean _default;

  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  CryptoKey() {
  }

  @JsProperty(
      name = "private"
  )
  @Nonnull
  public native Object _private();
}
