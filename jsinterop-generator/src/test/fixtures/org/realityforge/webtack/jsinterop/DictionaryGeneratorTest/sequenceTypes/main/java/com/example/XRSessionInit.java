package com.example;

import elemental2.core.JsArray;
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
    name = "?"
)
public interface XRSessionInit {
  @JsOverlay
  @Nonnull
  static XRSessionInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  @Nonnull
  JsArray<Any> getOptionalFeatures();

  @JsProperty
  void setOptionalFeatures(@Nonnull JsArray<Any> optionalFeatures);

  @JsProperty
  @Nonnull
  JsArray<Any> getRequiredFeatures();

  @JsProperty
  void setRequiredFeatures(@Nonnull JsArray<Any> requiredFeatures);
}
