package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "sessions"
  )
  JsArray<XRSessionInit> sessions();

  @JsProperty
  void setSessions(@JsNonNull JsArray<XRSessionInit> sessions);

  @JsOverlay
  default void setSessions(@Nonnull final XRSessionInit... sessions) {
    setSessions( Js.<JsArray<XRSessionInit>>uncheckedCast( sessions ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends Sub2 {
    @JsOverlay
    @Nonnull
    default Builder sessions(@Nonnull final JsArray<XRSessionInit> sessions) {
      setSessions( sessions );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder sessions(@Nonnull final XRSessionInit... sessions) {
      setSessions( sessions );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder others(@Nonnull final JsArray<Base> others) {
      setOthers( others );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder others(@Nonnull final Base... others) {
      setOthers( others );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder optionalFeatures(@Nonnull final JsArray<Any> optionalFeatures) {
      setOptionalFeatures( optionalFeatures );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder optionalFeatures(@Nonnull final Any... optionalFeatures) {
      setOptionalFeatures( optionalFeatures );
      return this;
    }
  }
}
