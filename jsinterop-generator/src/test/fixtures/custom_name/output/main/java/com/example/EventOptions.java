package com.example;

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
    name = "Object"
)
public interface EventOptions {
  @JsOverlay
  @Nonnull
  static EventOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "bubbles"
  )
  boolean bubbles();

  @JsProperty
  void setBubbles(boolean bubbles);

  @JsOverlay
  @Nonnull
  default EventOptions bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsProperty(
      name = "cancelable"
  )
  boolean cancelable();

  @JsProperty
  void setCancelable(boolean cancelable);

  @JsOverlay
  @Nonnull
  default EventOptions cancelable(final boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsProperty(
      name = "composed"
  )
  boolean composed();

  @JsProperty
  void setComposed(boolean composed);

  @JsOverlay
  @Nonnull
  default EventOptions composed(final boolean composed) {
    setComposed( composed );
    return this;
  }
}
