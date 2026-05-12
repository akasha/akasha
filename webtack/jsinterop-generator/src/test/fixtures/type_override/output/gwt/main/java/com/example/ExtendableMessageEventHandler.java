package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface ExtendableMessageEventHandler {
  void onInvoke(@JsNonNull ExtendableMessageEvent event);
}
