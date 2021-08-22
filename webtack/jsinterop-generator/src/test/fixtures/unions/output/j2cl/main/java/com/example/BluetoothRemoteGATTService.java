package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "BluetoothRemoteGATTService"
)
public class BluetoothRemoteGATTService extends EventTarget {
  protected BluetoothRemoteGATTService() {
  }

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(
      @Nonnull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(@Nonnull String service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull String service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices();
}
