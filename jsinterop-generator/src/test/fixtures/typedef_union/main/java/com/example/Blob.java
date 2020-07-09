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
    name = "Object"
)
public class Blob {
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  Blob() {
  }

  @JsProperty(
      name = "type"
  )
  @Nonnull
  public native String type();
}
