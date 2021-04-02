package com.example;

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
    name = "Object"
)
public interface Sub2 extends Sub1 {
  @JsOverlay
  @Nonnull
  static Sub2 create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "sessions"
  )
  JsArray<XRSessionInit> sessions();

  @JsProperty
  void setSessions(@Nonnull JsArray<XRSessionInit> sessions);

  @JsOverlay
  @Nonnull
  default Sub2 sessions(@Nonnull final JsArray<XRSessionInit> sessions) {
    setSessions( sessions );
    return this;
  }

  @JsOverlay
  default void setSessions(@Nonnull final XRSessionInit... sessions) {
    setSessions( Js.<JsArray<XRSessionInit>>uncheckedCast( sessions ) );
  }

  @JsOverlay
  @Nonnull
  default Sub2 sessions(@Nonnull final XRSessionInit... sessions) {
    setSessions( sessions );
    return this;
  }

  @JsOverlay
  @Nonnull
  default Sub2 others(@Nonnull final JsArray<Base> others) {
    setOthers( others );
    return this;
  }

  @JsOverlay
  @Nonnull
  default Sub2 others(@Nonnull final Base... others) {
    setOthers( others );
    return this;
  }

  @JsOverlay
  @Nonnull
  default Sub2 optionalFeatures(@Nonnull final JsArray<Any> optionalFeatures) {
    setOptionalFeatures( optionalFeatures );
    return this;
  }

  @JsOverlay
  @Nonnull
  default Sub2 optionalFeatures(@Nonnull final Any... optionalFeatures) {
    setOptionalFeatures( optionalFeatures );
    return this;
  }
}
