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
public interface RTCCertificateStats {
  @JsOverlay
  @Nonnull
  static RTCCertificateStats create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "isNot"
  )
  String _isNot();

  @JsProperty
  void setIsNot(@Nonnull String isNot);

  @JsOverlay
  @Nonnull
  default RTCCertificateStats isNot(@Nonnull final String isNot) {
    setIsNot( isNot );
    return this;
  }

  @JsProperty(
      name = "issuerCertificateId"
  )
  String _issuerCertificateId();

  @JsProperty
  void setIssuerCertificateId(@Nonnull String issuerCertificateId);

  @JsOverlay
  @Nonnull
  default RTCCertificateStats issuerCertificateId(@Nonnull final String issuerCertificateId) {
    setIssuerCertificateId( issuerCertificateId );
    return this;
  }
}
