package com.example;

import elemental3.MyAnnotation;
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
    name = "?"
)
@MyAnnotation
public interface EventInit {
  @JsOverlay
  @Nonnull
  static EventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "bubbles"
  )
  @MyAnnotation
  boolean bubbles();

  @JsProperty
  void setBubbles(@MyAnnotation boolean bubbles);

  @JsOverlay
  @Nonnull
  default EventInit bubbles(@MyAnnotation final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }
}
