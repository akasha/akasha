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
    name = "EventInit"
)
public interface EventOptions {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "bubbles"
  )
  boolean bubbles();

  @JsProperty
  void setBubbles(boolean bubbles);

  @JsProperty(
      name = "cancelable"
  )
  boolean cancelable();

  @JsProperty
  void setCancelable(boolean cancelable);

  @JsProperty(
      name = "composed"
  )
  boolean composed();

  @JsProperty
  void setComposed(boolean composed);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventInit"
  )
  interface Builder extends EventOptions {
    @JsOverlay
    @Nonnull
    default Builder bubbles(final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder cancelable(final boolean cancelable) {
      setCancelable( cancelable );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder composed(final boolean composed) {
      setComposed( composed );
      return this;
    }
  }
}
