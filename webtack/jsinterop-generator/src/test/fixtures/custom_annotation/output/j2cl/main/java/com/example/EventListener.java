package com.example;

import akasha.MyAnnotation;
import akasha.MyAnnotation2;
import akasha.MyAnnotation3;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
@FunctionalInterface
@MyAnnotation
public interface EventListener {
  @MyAnnotation3
  void handleEvent(@MyAnnotation2 @JsNonNull Event event);
}
