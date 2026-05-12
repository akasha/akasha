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
    name = "PermissionStatus"
)
public class PermissionStatus {
  protected PermissionStatus() {
  }

  @JsProperty(
      name = "state"
  )
  @Nonnull
  @PermissionState
  public native String state();
}
