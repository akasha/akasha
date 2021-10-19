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
  static Builder bubbles2(@MyAnnotation final boolean bubbles2) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).bubbles2( bubbles2 );
  }

  @JsProperty(
      name = "bubbles2"
  )
  @MyAnnotation
  boolean bubbles2();

  @JsProperty
  void setBubbles2(@MyAnnotation boolean bubbles2);

  @JsProperty(
      name = "bubbles"
  )
  @MyAnnotation
  boolean bubbles();

  @JsProperty
  void setBubbles(@MyAnnotation boolean bubbles);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventInit"
  )
  @MyAnnotation
  interface Builder extends EventInit {
    @JsOverlay
    @Nonnull
    default Builder bubbles2(@MyAnnotation final boolean bubbles2) {
      setBubbles2( bubbles2 );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder bubbles(@MyAnnotation final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }
  }
}
