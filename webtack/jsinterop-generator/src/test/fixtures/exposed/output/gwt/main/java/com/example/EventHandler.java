package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface EventHandler {
  void onInvoke(@JsNonNull Event event);
}
