package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Document"
)
public class Document {
  protected Document() {
  }

  @JsNonNull
  public native Document open(@Nonnull String unused1, @Nonnull String unused2);

  @JsNonNull
  public native Document open(@Nonnull String unused1);

  @JsNonNull
  public native Document open();

  @JsNullable
  public native Window open(@Nonnull String url, @Nonnull String name, @Nonnull String features);
}
