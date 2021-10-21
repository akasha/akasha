package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class RTCCertificateStatsTestCompile {
  static RTCCertificateStats $typeReference$;

  public static RTCCertificateStats.Builder of() {
    return RTCCertificateStats.of();
  }

  public static String _isNot(final RTCCertificateStats $instance) {
    return $instance._isNot();
  }

  public static void setIsNot(final RTCCertificateStats $instance, String isNot) {
    $instance.setIsNot( isNot );
  }

  public static String _issuerCertificateId(final RTCCertificateStats $instance) {
    return $instance._issuerCertificateId();
  }

  public static void setIssuerCertificateId(final RTCCertificateStats $instance,
      String issuerCertificateId) {
    $instance.setIssuerCertificateId( issuerCertificateId );
  }

  public static RTCCertificateStats.Builder isNot(final RTCCertificateStats.Builder $instance,
      final String isNot) {
    return $instance.isNot( isNot );
  }

  public static RTCCertificateStats.Builder issuerCertificateId(
      final RTCCertificateStats.Builder $instance, final String issuerCertificateId) {
    return $instance.issuerCertificateId( issuerCertificateId );
  }
}
