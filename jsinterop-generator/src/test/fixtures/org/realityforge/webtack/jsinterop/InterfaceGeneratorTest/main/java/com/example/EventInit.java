package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface EventInit {
  @JsProperty
  boolean isBubbles();

  @JsProperty
  void setBubbles(boolean bubbles);

  @JsProperty
  boolean isCancelable();

  @JsProperty
  void setCancelable(boolean cancelable);

  @JsProperty
  boolean isComposed();

  @JsProperty
  void setComposed(boolean composed);
}
