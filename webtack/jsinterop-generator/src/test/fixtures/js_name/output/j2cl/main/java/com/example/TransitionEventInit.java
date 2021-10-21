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
    name = "JsTransitionEventInit"
)
public interface TransitionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "js_pseudoElement"
  )
  String pseudoElement();

  @JsProperty
  void setPseudoElement(@JsNonNull String pseudoElement);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "JsTransitionEventInit"
  )
  interface Builder extends TransitionEventInit {
    @JsOverlay
    @Nonnull
    default Builder pseudoElement(@Nonnull final String pseudoElement) {
      setPseudoElement( pseudoElement );
      return this;
    }

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
  }
}
