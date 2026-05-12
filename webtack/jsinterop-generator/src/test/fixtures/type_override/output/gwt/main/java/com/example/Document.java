package com.example;

import javax.annotation.processing.Generated;
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
  public native Document open(@JsNonNull String unused1, @JsNonNull String unused2);

  @JsNonNull
  public native Document open(@JsNonNull String unused1);

  @JsNonNull
  public native Document open();

  @JsNullable
  public native Window open(@JsNonNull String url, @JsNonNull String name,
      @JsNonNull String features);
}
