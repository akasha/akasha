package com.example.mycallbacks;

import com.example.myinterfaces.Event;
import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface MyEventHandler {
  void onInvoke(@Nonnull Event event);
}
