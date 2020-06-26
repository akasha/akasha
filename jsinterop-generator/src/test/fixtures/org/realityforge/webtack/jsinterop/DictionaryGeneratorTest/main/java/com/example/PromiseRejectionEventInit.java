package com.example;

import elemental2.core.Promise;
import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public class PromiseRejectionEventInit extends EventInit {
  public Promise promise;

  public Any reason;
}
