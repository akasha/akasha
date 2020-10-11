package com.example;

import elemental3.MyAnnotation;
import elemental3.MyAnnotation2;
import elemental3.MyAnnotation3;
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
