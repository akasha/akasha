package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "PermissionStatus"
)
public class PermissionStatus {
  PermissionStatus() {
  }

  @JsProperty(
      name = "state"
  )
  @Nonnull
  @MagicConstant(
      valuesFromClass = PermissionState.class
  )
  public native String state();
}
