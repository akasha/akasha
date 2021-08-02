package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "NotHTMLCollection"
)
public class HTMLCollection {
  protected HTMLCollection() {
  }

  @JsProperty(
      name = "length"
  )
  public native int length();

  @HasNoSideEffects
  @Nullable
  public native Element item(int index);

  @HasNoSideEffects
  @Nullable
  public native Element namedItem(@Nonnull String name);
}
