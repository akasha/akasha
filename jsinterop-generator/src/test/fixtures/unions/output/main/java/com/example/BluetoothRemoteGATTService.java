package com.example;

import elemental2.core.JsArray;
import elemental2.promise.Promise;
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
  BluetoothRemoteGATTService() {
  }

  @Nonnull
  public native Promise<BluetoothRemoteGATTService> getIncludedService(
      @Nonnull BluetoothServiceUUID service);

  @Nonnull
  public native Promise<BluetoothRemoteGATTService> getIncludedService(@Nonnull String service);

  @Nonnull
  public native Promise<BluetoothRemoteGATTService> getIncludedService(int service);

  @Nonnull
  public native Promise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull BluetoothServiceUUID service);

  @Nonnull
  public native Promise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(
      @Nonnull String service);

  @Nonnull
  public native Promise<JsArray<BluetoothRemoteGATTService>> getIncludedServices(int service);

  @Nonnull
  public native Promise<JsArray<BluetoothRemoteGATTService>> getIncludedServices();
}
