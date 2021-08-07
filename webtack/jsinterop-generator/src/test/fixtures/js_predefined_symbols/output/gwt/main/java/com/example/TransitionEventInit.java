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
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "propertyName3"
  )
  String propertyName3();

  @JsProperty
  void setPropertyName3(@Nonnull String propertyName3);

  @JsProperty(
      name = "js_pseudoElement"
  )
  String pseudoElement();

  @JsProperty
  void setPseudoElement(@Nonnull String pseudoElement);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends TransitionEventInit {
    @JsOverlay
    @Nonnull
    default Builder propertyName3(@Nonnull final String propertyName3) {
      setPropertyName3( propertyName3 );
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
    default Builder propertyName2(@Nonnull final String propertyName2) {
      setPropertyName2( propertyName2 );
      return this;
    }
  }
}
