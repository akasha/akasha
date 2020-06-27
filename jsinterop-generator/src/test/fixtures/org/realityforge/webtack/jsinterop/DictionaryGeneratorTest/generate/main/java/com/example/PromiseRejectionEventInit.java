package com.example;

import elemental2.core.Promise;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface PromiseRejectionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static PromiseRejectionEventInit create(@Nonnull final Promise promise) {
    final PromiseRejectionEventInit $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setPromise( promise );
    return $instance$;
  }

  @JsProperty
  @Nonnull
  Promise getPromise();

  @JsProperty
  void setPromise(@Nonnull Promise promise);

  @JsProperty
  Any getReason();

  @JsProperty
  void setReason(@Nonnull Any reason);
}
