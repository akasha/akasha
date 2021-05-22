package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class RTCPeerConnectionTestCompile {
  static RTCPeerConnection $typeReference$;

  public static JsPromise<RTCSessionDescriptionInit> createOffer(final RTCPeerConnection $instance,
      final RTCOfferOptions options) {
    return $instance.createOffer( options );
  }

  public static JsPromise<RTCSessionDescriptionInit> createOffer(
      final RTCPeerConnection $instance) {
    return $instance.createOffer();
  }

  public static JsPromise<Void> createOffer(final RTCPeerConnection $instance,
      final RTCSessionDescriptionCallback successCallback,
      final RTCPeerConnectionErrorCallback failureCallback, final RTCOfferOptions options) {
    return $instance.createOffer( successCallback, failureCallback, options );
  }

  public static JsPromise<Void> createOffer(final RTCPeerConnection $instance,
      final RTCSessionDescriptionCallback successCallback,
      final RTCPeerConnectionErrorCallback failureCallback) {
    return $instance.createOffer( successCallback, failureCallback );
  }
}
