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
    name = "HTMLSelectElement"
)
public class HTMLSelectElement {
  protected HTMLSelectElement() {
  }

  @JsProperty(
      name = "selectedOptions"
  )
  @Nonnull
  public native HTMLReadOnlyOptionsCollection selectedOptions();
}
