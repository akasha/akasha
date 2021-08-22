package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "TransitionEventInit"
)
public interface TransitionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "elapsedTime"
  )
  double elapsedTime();

  @JsProperty
  void setElapsedTime(double elapsedTime);

  @JsProperty(
      name = "propertyName"
  )
  String propertyName();

  @JsProperty
  void setPropertyName(@JsNonNull String propertyName);

  @JsProperty(
      name = "pseudoElement"
  )
  String pseudoElement();

  @JsProperty
  void setPseudoElement(@JsNonNull String pseudoElement);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "TransitionEventInit"
  )
  interface Builder extends TransitionEventInit {
    @JsOverlay
    @Nonnull
    default Builder elapsedTime(final double elapsedTime) {
      setElapsedTime( elapsedTime );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder propertyName(@Nonnull final String propertyName) {
      setPropertyName( propertyName );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder pseudoElement(@Nonnull final String pseudoElement) {
      setPseudoElement( pseudoElement );
      return this;
    }

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
