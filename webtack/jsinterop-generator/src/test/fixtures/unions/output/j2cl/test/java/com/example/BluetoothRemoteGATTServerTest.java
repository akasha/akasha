package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class BluetoothRemoteGATTServerTest {
  static BluetoothRemoteGATTServer $typeReference$;

  public static JsPromise<BluetoothRemoteGATTService> getPrimaryService(
      final BluetoothRemoteGATTServer $instance, final BluetoothServiceUUID service) {
    return $instance.getPrimaryService( service );
  }

  public static JsPromise<BluetoothRemoteGATTService> getPrimaryService(
      final BluetoothRemoteGATTServer $instance, final String service) {
    return $instance.getPrimaryService( service );
  }

  public static JsPromise<BluetoothRemoteGATTService> getPrimaryService(
      final BluetoothRemoteGATTServer $instance, final int service) {
    return $instance.getPrimaryService( service );
  }

  public static JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      final BluetoothRemoteGATTServer $instance, final BluetoothServiceUUID service) {
    return $instance.getPrimaryServices( service );
  }

  public static JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      final BluetoothRemoteGATTServer $instance, final String service) {
    return $instance.getPrimaryServices( service );
  }

  public static JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      final BluetoothRemoteGATTServer $instance, final int service) {
    return $instance.getPrimaryServices( service );
  }

  public static JsPromise<JsArray<BluetoothRemoteGATTService>> getPrimaryServices(
      final BluetoothRemoteGATTServer $instance) {
    return $instance.getPrimaryServices();
  }
}
