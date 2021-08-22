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
    name = "BluetoothRemoteGATTServer"
)
public class BluetoothRemoteGATTServer {
  protected BluetoothRemoteGATTServer() {
  }

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getPrimaryService(
      @Nonnull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getPrimaryService(@Nonnull String service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getPrimaryService(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      @Nonnull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      @Nonnull String service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices();
}
