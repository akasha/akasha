package com.example.mycallbacks;

import com.example.myinterfaces.Event;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface MyEventHandler {
  void onInvoke(@Nonnull Event event);
}
