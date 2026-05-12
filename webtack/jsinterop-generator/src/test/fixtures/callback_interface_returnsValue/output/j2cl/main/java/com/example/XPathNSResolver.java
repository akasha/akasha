package com.example;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
@FunctionalInterface
public interface XPathNSResolver {
  @JsNullable
  String lookupNamespaceURI(@Nullable String prefix);
}
