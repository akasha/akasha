package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface ExtendableMessageEventHandler {
  void onInvoke(@Nonnull ExtendableMessageEvent event);
}
