package com.example;

import akasha.MyAnnotation;
import akasha.MyAnnotation2;
import akasha.MyAnnotation3;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  void handleEvent(@MyAnnotation2 @Nonnull Event event);
}
