package com.example;

import akasha.promise.Promise;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface ClipboardItemDelayedCallback {
  @Nonnull
  Promise<ClipboardItemDataType> onInvoke();
}
