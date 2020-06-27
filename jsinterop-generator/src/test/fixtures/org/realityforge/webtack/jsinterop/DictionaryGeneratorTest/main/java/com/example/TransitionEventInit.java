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

  @JsProperty
  @Nonnull
  String getPropertyName();

  @JsProperty
  void setPropertyName(@Nonnull String propertyName);

  @JsProperty
  @Nonnull
  String getPseudoElement();

  @JsProperty
  void setPseudoElement(@Nonnull String pseudoElement);
}
