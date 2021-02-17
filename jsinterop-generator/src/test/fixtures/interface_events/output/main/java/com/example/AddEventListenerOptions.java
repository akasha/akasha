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
public interface AddEventListenerOptions extends EventListenerOptions {
  @JsOverlay
  @Nonnull
  static AddEventListenerOptions create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "once"
  )
  boolean once();

  @JsProperty
  void setOnce(boolean once);

  @JsOverlay
  @Nonnull
  default AddEventListenerOptions once(final boolean once) {
    setOnce( once );
    return this;
  }

  @JsProperty(
      name = "passive"
  )
  boolean passive();

  @JsProperty
  void setPassive(boolean passive);

  @JsOverlay
  @Nonnull
  default AddEventListenerOptions passive(final boolean passive) {
    setPassive( passive );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default AddEventListenerOptions capture(final boolean capture) {
    setCapture( capture );
    return this;
  }
}
