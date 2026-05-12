package com.example;

import akasha.MyAnnotation;
import akasha.MyAnnotation2;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface MyEventHandler {
  @MyAnnotation
  void onInvoke(@MyAnnotation2 @JsNonNull Event event);
}
