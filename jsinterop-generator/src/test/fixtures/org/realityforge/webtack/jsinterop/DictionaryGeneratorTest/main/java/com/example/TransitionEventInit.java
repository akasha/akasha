package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface TransitionEventInit extends EventInit {
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
