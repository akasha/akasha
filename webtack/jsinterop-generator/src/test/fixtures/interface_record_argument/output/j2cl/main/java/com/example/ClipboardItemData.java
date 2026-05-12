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
    name = "ClipboardItemData"
)
public class ClipboardItemData {
  protected ClipboardItemData() {
  }

  @JsProperty(
      name = "data"
  )
  @Nonnull
  public native String data();
}
