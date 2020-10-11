package com.example;

import elemental3.MyAnnotation;
import elemental3.MyAnnotation2;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface MyEventHandler {
  @MyAnnotation
  void onInvoke(@MyAnnotation2 @Nonnull Event event);
}
