package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "HTMLCollection"
)
public class HTMLReadOnlyOptionsCollection extends HTMLCollection {
  protected HTMLReadOnlyOptionsCollection() {
  }

  @HasNoSideEffects
  @JsNullable
  public native HTMLOptionElement item(int index);

  @HasNoSideEffects
  @JsNullable
  public native HTMLOptionElement namedItem(@JsNonNull String name);
}
