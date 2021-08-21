package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "XMLHttpRequest"
)
public class XMLHttpRequest {
  @JsOverlay
  public static final int DONE = 4;

  @JsOverlay
  public static final int HEADERS_RECEIVED = 2;

  @JsOverlay
  public static final int LOADING = 3;

  @JsOverlay
  public static final int OPENED = 1;

  @JsOverlay
  public static final int UNSENT = 0;

  protected XMLHttpRequest() {
  }
}
