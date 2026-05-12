package com.example;

import javax.annotation.processing.Generated;
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
      @JsNonNull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getPrimaryService(@JsNonNull String service);

  @JsNonNull
  public native JsPromise<BluetoothRemoteGATTService> getPrimaryService(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      @JsNonNull BluetoothServiceUUID service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      @JsNonNull String service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(int service);

  @JsNonNull
  public native JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices();
}
