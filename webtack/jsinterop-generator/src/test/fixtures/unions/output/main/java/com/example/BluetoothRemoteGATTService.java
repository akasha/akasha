package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

  @Nonnull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(
      @Nonnull BluetoothServiceUUID service);

  @Nonnull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(@Nonnull String service);

  @Nonnull
  public native JsPromise<BluetoothRemoteGATTService> getIncludedService(int service);

  @Nonnull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull BluetoothServiceUUID service);

  @Nonnull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull String service);

  @Nonnull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(int service);

  @Nonnull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getIncludedServices();
}
