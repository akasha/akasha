package com.example;

import elemental2.core.Promise;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface PromiseRejectionEventInit extends EventInit {
  @JsProperty
  @Nonnull
  Promise getPromise();

  @JsProperty
  void setPromise(@Nonnull Promise promise);

  @JsProperty
  @Nonnull
  Any getReason();

  @JsProperty
  void setReason(@Nonnull Any reason);
}
