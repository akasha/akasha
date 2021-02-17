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
public interface TransitionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static TransitionEventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "elapsedTime"
  )
  double elapsedTime();

  @JsProperty
  void setElapsedTime(double elapsedTime);

  @JsOverlay
  @Nonnull
  default TransitionEventInit elapsedTime(final double elapsedTime) {
    setElapsedTime( elapsedTime );
    return this;
  }

  @JsProperty(
      name = "propertyName"
  )
  String propertyName();

  @JsProperty
  void setPropertyName(@Nonnull String propertyName);

  @JsOverlay
  @Nonnull
  default TransitionEventInit propertyName(@Nonnull final String propertyName) {
    setPropertyName( propertyName );
    return this;
  }

  @JsProperty(
      name = "pseudoElement"
  )
  String pseudoElement();

  @JsProperty
  void setPseudoElement(@Nonnull String pseudoElement);

  @JsOverlay
  @Nonnull
  default TransitionEventInit pseudoElement(@Nonnull final String pseudoElement) {
    setPseudoElement( pseudoElement );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default TransitionEventInit bubbles(final boolean bubbles) {
    setBubbles( bubbles );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default TransitionEventInit cancelable(final boolean cancelable) {
    setCancelable( cancelable );
    return this;
  }

  @JsOverlay
  @Nonnull
  @Override
  default TransitionEventInit composed(final boolean composed) {
    setComposed( composed );
    return this;
  }
}
