package com.example;

import akasha.MyAnnotation;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "EventInit"
)
@MyAnnotation
public interface EventInit {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "bubbles"
  )
  @MyAnnotation
  boolean bubbles();

  @JsProperty
  void setBubbles(@MyAnnotation boolean bubbles);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventInit"
  )
  @MyAnnotation
  interface Builder extends EventInit {
    @JsOverlay
    @Nonnull
    default Builder bubbles(@MyAnnotation final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }
  }
}
