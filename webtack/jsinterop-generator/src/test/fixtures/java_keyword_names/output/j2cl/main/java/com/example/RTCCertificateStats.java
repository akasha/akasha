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
    name = "RTCCertificateStats"
)
public interface RTCCertificateStats {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "isNot"
  )
  String _isNot();

  @JsProperty
  void setIsNot(@JsNonNull String isNot);

  @JsProperty(
      name = "issuerCertificateId"
  )
  String _issuerCertificateId();

  @JsProperty
  void setIssuerCertificateId(@JsNonNull String issuerCertificateId);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "RTCCertificateStats"
  )
  interface Builder extends RTCCertificateStats {
    @JsOverlay
    @Nonnull
    default Builder isNot(@Nonnull final String isNot) {
      setIsNot( isNot );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder issuerCertificateId(@Nonnull final String issuerCertificateId) {
      setIssuerCertificateId( issuerCertificateId );
      return this;
    }
  }
}
