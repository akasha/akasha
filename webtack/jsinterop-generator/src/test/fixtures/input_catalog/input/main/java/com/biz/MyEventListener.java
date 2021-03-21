package com.biz;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * This is a predefined type.
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
@FunctionalInterface
public interface MyEventListener
{
  void onEvent();
}
