package com.example;

import javaemul.internal.annotations.HasNoSideEffects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
  @Nullable
  public native HTMLOptionElement item(int index);

  @HasNoSideEffects
  @Nullable
  public native HTMLOptionElement namedItem(@Nonnull String name);
}
