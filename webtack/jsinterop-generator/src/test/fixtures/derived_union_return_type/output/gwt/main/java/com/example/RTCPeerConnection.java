package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "RTCPeerConnection"
)
public class RTCPeerConnection {
  protected RTCPeerConnection() {
  }

  @Nonnull
  public native JsPromise<RTCSessionDescriptionInit> createOffer(@Nonnull RTCOfferOptions options);

  @Nonnull
  public native JsPromise<RTCSessionDescriptionInit> createOffer();

  @Nonnull
  public native JsPromise<Void> createOffer(@Nonnull RTCSessionDescriptionCallback successCallback,
      @Nonnull RTCPeerConnectionErrorCallback failureCallback, @Nonnull RTCOfferOptions options);

  @Nonnull
  public native JsPromise<Void> createOffer(@Nonnull RTCSessionDescriptionCallback successCallback,
      @Nonnull RTCPeerConnectionErrorCallback failureCallback);
}
