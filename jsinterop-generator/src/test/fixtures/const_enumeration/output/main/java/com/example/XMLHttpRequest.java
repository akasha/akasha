package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
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

  /**
   * regular attribute is a const enum.
   */
  @Nonnull
  @ReadyStateType
  public int otherReadyState;

  public XMLHttpRequest(@ReadyStateType final int value) {
  }

  /**
   * readonly attribute is a const enum.
   */
  @JsProperty(
      name = "readyState"
  )
  @ReadyStateType
  public native int readyState();

  /**
   * operation return value is a const enum.
   */
  @ReadyStateType
  @Nonnull
  public native int getSample();

  /**
   * operation argument is an enum.
   */
  public native void setSample(@ReadyStateType int sample);
}
