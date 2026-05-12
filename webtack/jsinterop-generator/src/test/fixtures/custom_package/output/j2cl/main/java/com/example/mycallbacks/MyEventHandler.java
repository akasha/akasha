package com.example.mycallbacks;

import com.example.myinterfaces.Event;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsNonNull;

@Generated("org.realityforge.webtack")
@JsFunction
@FunctionalInterface
public interface MyEventHandler {
  void onInvoke(@JsNonNull Event event);
}
