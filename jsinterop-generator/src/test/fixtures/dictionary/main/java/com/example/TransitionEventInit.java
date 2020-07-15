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
    name = "?"
)
public interface TransitionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static TransitionEventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  double getElapsedTime();

  @JsProperty
  void setElapsedTime(double elapsedTime);

  @JsOverlay
  @Nonnull
  default TransitionEventInit elapsedTime(double elapsedTime) {
    setElapsedTime( elapsedTime );
    return this;
  }

  @JsProperty
  String getPropertyName();

  @JsProperty
  void setPropertyName(@Nonnull String propertyName);

  @JsOverlay
  @Nonnull
  default TransitionEventInit propertyName(@Nonnull String propertyName) {
    setPropertyName( propertyName );
    return this;
  }

  @JsProperty
  String getPseudoElement();

  @JsProperty
  void setPseudoElement(@Nonnull String pseudoElement);

  @JsOverlay
  @Nonnull
  default TransitionEventInit pseudoElement(@Nonnull String pseudoElement) {
    setPseudoElement( pseudoElement );
    return this;
  }
}
