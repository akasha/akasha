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
public interface EcdhKeyDeriveParams {
  @JsOverlay
  @Nonnull
  static EcdhKeyDeriveParams create(@Nonnull final CryptoKey _public) {
    final EcdhKeyDeriveParams $instance$ = Js.uncheckedCast( JsPropertyMap.of() );
    $instance$.setPublic( _public );
    return $instance$;
  }

  @JsProperty
  String getDefault();

  @JsProperty
  void setDefault(@Nonnull String _default);

  @JsOverlay
  @Nonnull
  default EcdhKeyDeriveParams _default(@Nonnull String _default) {
    setDefault( _default );
    return this;
  }

  @JsProperty
  @Nonnull
  CryptoKey getPublic();

  @JsProperty
  void setPublic(@Nonnull CryptoKey _public);

  @JsOverlay
  @Nonnull
  default EcdhKeyDeriveParams _public(@Nonnull CryptoKey _public) {
    setPublic( _public );
    return this;
  }
}
