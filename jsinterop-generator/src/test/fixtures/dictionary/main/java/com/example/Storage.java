package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public class Storage {
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  Storage() {
  }

  @JsProperty(
      name = "length"
  )
  public native int length();

  public native void clear();

  @Nullable
  public native String key(int index);
}
